package ar.com.echeq.model.dto.request;

import ar.com.echeq.model.dto.SignerDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RejectPaymentDTO {

    private String paymentType;
    private PaymentRejectionDTO rejection;
    private SignerDTO signer;

}