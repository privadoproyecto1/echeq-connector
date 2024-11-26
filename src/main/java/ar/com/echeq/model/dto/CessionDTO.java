package ar.com.echeq.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CessionDTO {
    private String cessionId;
    private String cessionStatus;
    private String assignorDocumentType;
    private String assignorDocument;
    private String assignorName;
    private String assigneeDocumentType;
    private String assigneeDocument;
    private String assigneeName;
    private String assigneeAddress;
    private String registrationEntity;
    private String cessionRepudiationReason;
    private LocalDateTime cessionIssuanceDate;
    private LocalDateTime cessionLastModificationDate;
}