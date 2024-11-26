package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoelsaRejection {
    @JsonProperty("cheque_id")
    private String echeqId;
    @JsonProperty("codigo_rechazo")
    private String rejectionCode;
    @JsonProperty("motivo_rechazo")
    private String rejectionReason;
}
