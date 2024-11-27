package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class CoelsaEcheqResponseGetPaymentReference {
    @JsonProperty("referencia")
    private String reference;

    @JsonProperty("valor")
    private String value;
}
