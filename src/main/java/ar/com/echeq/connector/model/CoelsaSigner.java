package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoelsaSigner {
    @JsonProperty("documento_tipo")
    private String documentType;
    @JsonProperty("documento")
    private String document;
}
