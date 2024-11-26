package ar.com.echeq.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignerDTO {
    private String document;
    private String documentType;
}