package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CoelsaGuarantor {
    @JsonProperty("aval_documento_tipo")
    private String guarantorDocumentType;

    @JsonProperty("aval_documento")
    private String guarantorDocument;

    @JsonProperty("aval_razon_social")
    private String guarantorBusinessName;

    @JsonProperty("aval_caracter")
    private String guarantorCharacter;

    @JsonProperty("aval_domicilio")
    private String guarantorAddress;

    @JsonProperty("aval_importe_avalado")
    private double guaranteedAmount;

    @JsonProperty("aval_sujeto_avalado")
    private String guaranteedSubject;

    @JsonProperty("aval_fecha")
    private Date guarantorDate;

    @JsonProperty("aval_entidad")
    private String guarantorEntity;

    @JsonProperty("aval_estado")
    private String guarantorStatus;
}

