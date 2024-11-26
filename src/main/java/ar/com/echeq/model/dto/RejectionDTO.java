package ar.com.echeq.model.dto;

import lombok.Data;

@Data
public class RejectionDTO {
    private String rejectionCode;
    private String dateTime;
    private String rejectionReason;
}