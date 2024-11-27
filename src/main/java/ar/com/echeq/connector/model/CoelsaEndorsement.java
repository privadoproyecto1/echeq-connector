package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CoelsaEndorsement {
    @JsonProperty("benef_documento")
    private String beneficiaryDocument;

    @JsonProperty("benef_documento_tipo")
    private String beneficiaryDocumentType;

    @JsonProperty("benef_razon_social")
    private String beneficiaryBusinessName;

    @JsonProperty("emisor_documento")
    private String issuerDocument;

    @JsonProperty("emisor_documento_tipo")
    private String issuerDocumentType;

    @JsonProperty("emisor_razon_social")
    private String issuerBusinessName;

    @JsonProperty("estado_endoso")
    private String endorsementStatus;

    @JsonProperty("fecha_hora")
    private Date dateTime;

    @JsonProperty("motivo_repudio")
    private String repudiationReason;

    @JsonProperty("tipo_endoso")
    private String endorsementType;

    @JsonProperty("total_referencias_pago")
    private int totalPaymentReferences;

    @JsonProperty("referencias_pago")
    private List<CoelsaPaymentReference> paymentReferences;
}
