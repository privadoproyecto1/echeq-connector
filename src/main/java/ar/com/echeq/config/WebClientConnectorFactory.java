package ar.com.echeq.config;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

public class WebClientConnectorFactory {

    public static ReactorClientHttpConnector createConnector(long connectTimeout, long readTimeout) {
        HttpClient httpClient = HttpClient.create()
                .responseTimeout(Duration.ofMillis(readTimeout))
                .option(io.netty.channel.ChannelOption.CONNECT_TIMEOUT_MILLIS, (int) connectTimeout);

        return new ReactorClientHttpConnector(httpClient);
    }
}