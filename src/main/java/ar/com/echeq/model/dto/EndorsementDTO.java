package ar.com.echeq.model.dto;


import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class EndorsementDTO {
    private String beneficiaryDocument;
    private String beneficiaryDocumentType;
    private String beneficiaryBusinessName;
    private String issuerDocument;
    private String issuerDocumentType;
    private String issuerBusinessName;
    private String endorsementStatus;
    private Date dateTime;
    private String endorsementType;
    private int totalPaymentReferences;
    private List<PaymentReferenceDTO> paymentReferences;
}
