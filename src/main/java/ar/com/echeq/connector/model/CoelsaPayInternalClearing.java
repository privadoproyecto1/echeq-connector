package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CoelsaPayInternalClearing {
    @JsonProperty("tipo_pago")
    private String paymentType;

    @JsonProperty("pagos")
    private List<CoelsaPayment> payments;

    @JsonProperty("firmantes")
    private List<CoelsaSigner> signers;

}
