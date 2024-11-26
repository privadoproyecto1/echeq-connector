package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CoelsaRejectPayment {

    @JsonProperty("tipo_pago")
    private String paymentType;
    @JsonProperty("rechazos")
    private List<CoelsaRejection> rejections;
    @JsonProperty("firmantes")
    private List<CoelsaSigner> signers;

}
