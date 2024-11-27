package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CoelsaGetRejections {
    @JsonProperty("codigo_rechazo")
    private String rejectionCode;

    @JsonProperty("fecha_hora")
    private String dateTime;

    @JsonProperty("motivo_rechazo")
    private String rejectionReason;
}