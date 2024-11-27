package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CoelsaAssignment {
    @JsonProperty("cesion_id")
    private String assignmentId;

    @JsonProperty("estado_cesion")
    private String assignmentStatus;

    @JsonProperty("cedente_documento_tipo")
    private String assignorDocumentType;

    @JsonProperty("cedente_documento")
    private String assignorDocument;

    @JsonProperty("cedente_nombre")
    private String assignorName;

    @JsonProperty("cesionario_documento")
    private String assigneeDocument;

    @JsonProperty("cesionario_documento_tipo")
    private String assigneeDocumentType;

    @JsonProperty("cesionario_nombre")
    private String assigneeName;

    @JsonProperty("cesionario_domicilio")
    private String assigneeAddress;

    @JsonProperty("entidad_resp_registracion")
    private String registrationResponsibleEntity;

    @JsonProperty("cesion_motivo_repudio")
    private String assignmentRepudiationReason;

    @JsonProperty("fecha_emision_cesion")
    private Date assignmentIssuanceDate;

    @JsonProperty("fecha_ult_modificacion_cesion")
    private Date assignmentLastModificationDate;
}
