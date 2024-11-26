package ar.com.echeq.model.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InternalClearingDTO {
    private String echeqId;
    private String beneficiaryDocumentType;
    private String beneficiaryDocument;
}
