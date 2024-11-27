package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CoelsaEcheqsResponse {

    @JsonProperty("cheques")
    private List<CoelsaEcheq> coelsaEcheq;

    @JsonProperty("respuesta")
    private CoelsaEcheqsResponse response;

    @Data
    public static class CoelsaEcheq {

        @JsonProperty("agrupador_id")
        private int groupId;

        @JsonProperty("certificado_emitido")
        private boolean certificateIssued;

        @JsonProperty("cheque_acordado")
        private boolean agreedCheque;

        @JsonProperty("cheque_caracter")
        private String chequeCharacter;

        @JsonProperty("cheque_concepto")
        private String chequeConcept;

        @JsonProperty("cheque_id")
        private String chequeId;

        @JsonProperty("cheque_modo")
        private int chequeMode;

        @JsonProperty("cheque_motivo_pago")
        private String chequePaymentReason;

        @JsonProperty("cheque_numero")
        private String chequeNumber;

        @JsonProperty("cheque_tipo")
        private String chequeType;

        @JsonProperty("cmc7")
        private String cmc7;

        @JsonProperty("cod_visualizacion")
        private String visualizationCode;

        @JsonProperty("codigo_emision")
        private String issuanceCode;

        @JsonProperty("estado")
        private String status;

        @JsonProperty("fecha_emision")
        private Date issuanceDate;

        @JsonProperty("fecha_pago")
        private Date paymentDate;

        @JsonProperty("fecha_pago_vencida")
        private boolean paymentDateExpired;

        @JsonProperty("monto")
        private double amount;

        @JsonProperty("motivo_anulacion")
        private String cancellationReason;

        @JsonProperty("motivo_repudio_emision")
        private String issuanceRepudiationReason;

        @JsonProperty("motivo_devolucion")
        private String returnReason;

        @JsonProperty("numero_chequera")
        private String checkbookNumber;

        @JsonProperty("re_presentar")
        private boolean rePresent;

        @JsonProperty("repudio_endoso")
        private boolean endorsementRepudiation;

        @JsonProperty("solicitando_acuerdo")
        private boolean requestingAgreement;

        @JsonProperty("onp")
        private boolean onp;

        @JsonProperty("acuerdo_rechazado")
        private boolean agreementRejected;

        @JsonProperty("fecha_ult_modif")
        private Date lastModificationDate;

        @JsonProperty("cbu_custodia")
        private String custodyCbu;

        @JsonProperty("cbu_deposito")
        private String depositCbu;

        @JsonProperty("cuit_solic_devol")
        private String returnRequestCuit;

        @JsonProperty("beneficiario_final_documento_tipo")
        private String finalBeneficiaryDocumentType;

        @JsonProperty("beneficiario_final_documento")
        private String finalBeneficiaryDocument;

        @JsonProperty("nro_lote")
        private String batchNumber;

        @JsonProperty("cedido")
        private boolean assigned;

        @JsonProperty("cesion_pendiente")
        private boolean pendingAssignment;

        @JsonProperty("beneficiario_final_nombre")
        private String finalBeneficiaryName;

        @JsonProperty("es_ultimo_endosante")
        private boolean isLastEndorser;

        @JsonProperty("avalado")
        private boolean guaranteed;

        @JsonProperty("mandato_cobro")
        private boolean collectionMandate;

        @JsonProperty("mandato_neg")
        private boolean negotiationMandate;

        @JsonProperty("es_ultimo_mandante")
        private boolean isLastMandator;

        @JsonProperty("ultimo_endosante_razon_social")
        private String lastEndorserBusinessName;

        @JsonProperty("cuenta_emisora")
        private CoelsaIssuingAccount issuingAccount;

        @JsonProperty("emitido_a")
        private CoelsaIssuedTo issuedTo;

        @JsonProperty("tenencia")
        private CoelsaTenure tenure;

        @JsonProperty("total_endosos")
        private int totalEndorsements;

        @JsonProperty("endosos")
        private List<CoelsaEndorsement> endorsements;

        @JsonProperty("total_chq_referencias_pago")
        private int totalChequePaymentReferences;

        @JsonProperty("chq_referencias_pago")
        private List<CoelsaEcheqResponseGetPaymentReference> chequePaymentReferences;

        @JsonProperty("total_rechazos")
        private int totalRejections;

        @JsonProperty("rechazos")
        private List<CoelsaGetRejections> rejections;

        @JsonProperty("total_avalistas")
        private int totalGuarantors;

        @JsonProperty("avalistas")
        private List<CoelsaGuarantor> guarantors;

        @JsonProperty("total_cesiones")
        private int totalAssignments;

        @JsonProperty("cesiones")
        private List<CoelsaAssignment> assignments;
    }
}