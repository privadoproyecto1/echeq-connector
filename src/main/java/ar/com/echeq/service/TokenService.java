package ar.com.echeq.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.reactive.function.client.WebClient;

public class TokenService {
    private final WebClient tokenWebClient;

    public TokenService(@Qualifier("tokenWebClient") WebClient tokenWebClient) {
        this.tokenWebClient = tokenWebClient;
    }

    public String getTokenFromCoelsa() {

        return tokenWebClient.post()
                .uri("/api/v1/token")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
