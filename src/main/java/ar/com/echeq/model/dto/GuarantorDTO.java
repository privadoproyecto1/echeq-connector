package ar.com.echeq.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class GuarantorDTO {
    private String guarantorDocumentType;
    private String guarantorDocument;
    private String guarantorBusinessName;
    private String guarantorCharacter;
    private String guarantorAddress;
    private String guaranteedAmount;
    private String guaranteedSubject;
    private LocalDateTime guarantorDate;
    private String guarantorEntity;
    private String guarantorStatus;
}
