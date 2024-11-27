package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public  class CoelsaIssuedTo {
    @JsonProperty("beneficiario_documento")
    private String beneficiaryDocument;

    @JsonProperty("beneficiario_documento_yipo")
    private String beneficiaryDocumentType;

    @JsonProperty("beneficiario_nombre")
    private String beneficiaryName;
}
