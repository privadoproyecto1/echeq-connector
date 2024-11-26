package ar.com.echeq.config;

import ar.com.echeq.service.TokenService;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.time.Instant;

@Configuration
public class WebClientConfig {

    private final TokenService tokenService;

    public static final char[] PASSWORD_CHAR_ARRAY = "password".toCharArray();

    public WebClientConfig(@Lazy TokenService tokenService) {
        this.tokenService = tokenService;
    }


    @Bean(name = "tokenWebClient")
    public WebClient serviceAClient(
            @Value("${tokenWebClient.base-url}") String baseUrl,
            @Value("${tokenWebClient.timeout.connect}") long connectTimeout,
            @Value("${tokenWebClient.timeout.read}") long readTimeout) {

        return WebClient.builder()
                .baseUrl(baseUrl)
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)) // 16MB buffer
                        .build())
                .clientConnector(WebClientConnectorFactory.createConnector(connectTimeout, readTimeout))
                .build();
    }

    @Bean(name = "coelsaClient")
    public WebClient serviceBClient(
            @Value("${coelsaClient.base-url}") String baseUrl,
            @Value("${coelsaClient.timeout.connect}") long connectTimeout,
            @Value("${coelsaClient.timeout.read}") long readTimeout,
            @Value("${coelsaClient.cert}") String cert,
            @Value("${coelsaClient.key}") String key) throws Exception {

        SslContext sslContext = createSslContext(cert, key);
        HttpClient httpClient = HttpClient.create()
                .secure(ssl -> ssl.sslContext(sslContext));

        return WebClient.builder()
                .baseUrl(baseUrl)
                .clientConnector(WebClientConnectorFactory.createConnector(connectTimeout, readTimeout))
                .filter(addCustomHeadersFilter())
                .build();
    }

    private SslContext createSslContext(String cert, String key) throws Exception {

        String formattedCert = cert.replace("\\n", "\n");
        String formattedKey = key.replace("\\n", "\n");

        KeyStore keyStore = createKeyStore(formattedCert, formattedKey);

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, PASSWORD_CHAR_ARRAY);

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);

        return SslContextBuilder.forClient()
                .keyManager(keyManagerFactory)
                .trustManager(trustManagerFactory)
                .build();
    }

    public KeyStore createKeyStore(String certStr, String secretKey) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, PASSWORD_CHAR_ARRAY);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        Certificate cert = cf.generateCertificate(new ByteArrayInputStream(certStr.getBytes()));
        Certificate[] certChain = new Certificate[1];
        certChain[0] = cert;
        PrivateKey key = getPrivateKey(secretKey);
        keyStore.setKeyEntry("coelsa_certificate", (Key) key, PASSWORD_CHAR_ARRAY, certChain);
        return keyStore;
    }

    public PrivateKey getPrivateKey(String secretKey) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        StringReader stringReader = new StringReader(secretKey);
        PEMParser pemParser = new PEMParser(stringReader);
        Object object = pemParser.readObject();
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
        if (object instanceof PEMKeyPair)
            return converter.getKeyPair((PEMKeyPair) object).getPrivate();
        if (object instanceof PrivateKeyInfo)
            return converter.getPrivateKey((PrivateKeyInfo) object);
        throw new RuntimeException("No se pudo obtener la privatekey");
    }

    private ExchangeFilterFunction addCustomHeadersFilter() {
        return (request, next) -> next.exchange(
                ClientRequest.from(request)
                        .headers(headers -> {
                            headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + tokenService.getTokenFromCoelsa());
                            headers.set("X-Time", String.valueOf(Instant.now().getEpochSecond()));
                        })
                        .build()
        );
    }
}