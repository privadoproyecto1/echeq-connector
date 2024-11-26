package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoelsaPayment {
    @JsonProperty("cheque_id")
    private String echeqId;

    @JsonProperty("beneficiario_documento_tipo")
    private String beneficiaryDocumentType;

    @JsonProperty("beneficiario_documento")
    private String beneficiaryDocument;
}
