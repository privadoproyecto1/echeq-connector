package ar.com.echeq.connector;

import ar.com.echeq.connector.model.*;
import ar.com.echeq.model.dto.enums.CoelsaApiUri;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Component
public class CoelsaClientConnector {

    private final WebClient coelsaClient;

    public CoelsaClientConnector(@Qualifier("coelsaClient") WebClient coelsaClient) {
        this.coelsaClient = coelsaClient;
    }

    public CoelsaEcheqResponse getEcheq(String filterString, String selectString) {
        return coelsaClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(CoelsaApiUri.GET_ECHEQ_BY_ID.getValue())
                        .queryParam("$filter", filterString)
                        .queryParam("$select", selectString)
                        .build())
                .retrieve()
                .bodyToMono(CoelsaEcheqResponse.class)
                .block();
    }

    public Flux<CoelsaEcheqsResponse> getEcheqs(String filterString, String pagString, String orderBy, String selectString) {
        return coelsaClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(CoelsaApiUri.GET_ECHEQS.getValue())
                        .queryParam("$filter", filterString)
                        .queryParam("$pag", pagString)
                        .queryParam("$orderby", orderBy)
                        .queryParam("$select", selectString)
                        .build())
                .retrieve()
                .bodyToFlux(CoelsaEcheqsResponse.class);
    }

    public CoelsaEcheqPaymentsResponse rejectPayment(CoelsaRejectPayment rejectPaymentDTO) {
        return coelsaClient
                .post()
                .uri(uriBuilder -> uriBuilder
                        .path(CoelsaApiUri.REJECT_PAYMENT_INTERNAL_EXCHANGE.getValue())
                        .build())
                .bodyValue(rejectPaymentDTO)
                .retrieve()
                .bodyToMono(CoelsaEcheqPaymentsResponse.class)
                .block();
    }

    public CoelsaEcheqPaymentsResponse rejectOutsideClearing(CoelsaRejectOutsideClearing coelsaRejectPayment) {
        return coelsaClient
                .post()
                .uri(uriBuilder -> uriBuilder
                        .path(CoelsaApiUri.REJECT_PAYMENT_OUTSIDE_CLEARING.getValue())
                        .build())
                .bodyValue(coelsaRejectPayment)
                .retrieve()
                .bodyToMono(CoelsaEcheqPaymentsResponse.class)
                .block();
    }

    public CoelsaEcheqPaymentsResponse payInternalClearing(Object coelsaInternalClearing) {
        return coelsaClient
                .post()
                .uri(uriBuilder -> uriBuilder
                        .path(CoelsaApiUri.PAY_INTERNAL_CLEARING.getValue())
                        .build())
                .bodyValue(coelsaInternalClearing)
                .retrieve()
                .bodyToMono(CoelsaEcheqPaymentsResponse.class)
                .block();
    }
}
