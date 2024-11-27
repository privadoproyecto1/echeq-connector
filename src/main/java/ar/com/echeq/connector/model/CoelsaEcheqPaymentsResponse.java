package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CoelsaEcheqPaymentsResponse {
    @JsonProperty("respuesta")
    private List<EcheqResponse> response;

    @Data
    @Builder
    public static class EcheqResponse {
        @JsonProperty("cheque_id")
        private String echeqId;
        @JsonProperty("respuesta")
        private ResponseDetail response;

        @Data
        @Builder
        public static class ResponseDetail {
            @JsonProperty("codigo")
            private String code;
            @JsonProperty("descripcion")
            private String description;
        }
    }
}
