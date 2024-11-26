package ar.com.echeq.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentReferenceDTO {
    private String reference;
    private String value;
}
