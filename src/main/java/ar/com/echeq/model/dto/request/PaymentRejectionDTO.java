package ar.com.echeq.model.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentRejectionDTO {
    private String echeqId;
    private String rejectionCode;
    private String rejectionReason;
}