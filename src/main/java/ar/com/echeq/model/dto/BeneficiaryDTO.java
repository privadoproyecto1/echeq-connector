package ar.com.echeq.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BeneficiaryDTO {
    private String beneficiaryDocument;
    private String beneficiaryDocumentType;
    private String beneficiaryName;
}