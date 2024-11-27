package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CoelsaTenure {
    @JsonProperty("beneficiario_documento")
    private String beneficiaryDocument;

    @JsonProperty("beneficiario_documento_tipo")
    private String beneficiaryDocumentType;

    @JsonProperty("beneficiario_nombre")
    private String beneficiaryName;
}
