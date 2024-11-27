package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CoelsaResponseData {
    @JsonProperty("codigo")
    private String code;

    @JsonProperty("descripcion")
    private String description;
}
