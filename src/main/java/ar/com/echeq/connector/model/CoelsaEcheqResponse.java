package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CoelsaEcheqResponse {

    @JsonProperty("cheque")
    private CoelsaEcheq coelsaEcheq;

    @JsonProperty("respuesta")
    private CoelsaEcheqsResponse response;

    @Data
    public static class CoelsaEcheq {
        @JsonProperty("totalFirmantes")
        private int totalSigners;

        @JsonProperty("firmantes")
        private List<CoelsaSigner> signers;

        @JsonProperty("agrupadorId")
        private int groupId;

        @JsonProperty("certificadoEmitido")
        private boolean certificateIssued;

        @JsonProperty("chequeAcordado")
        private boolean agreedCheque;

        @JsonProperty("chequeCaracter")
        private String chequeCharacter;

        @JsonProperty("chequeConcepto")
        private String chequeConcept;

        @JsonProperty("chequeId")
        private String chequeId;

        @JsonProperty("chequeModo")
        private int chequeMode;

        @JsonProperty("chequeMotivoPago")
        private String chequePaymentReason;

        @JsonProperty("chequeNumero")
        private String chequeNumber;

        @JsonProperty("chequeTipo")
        private String chequeType;

        @JsonProperty("cmc7")
        private String cmc7;

        @JsonProperty("codVisualizacion")
        private String visualizationCode;

        @JsonProperty("codigoEmision")
        private String issuanceCode;

        @JsonProperty("estado")
        private String status;

        @JsonProperty("fechaEmision")
        private LocalDateTime issuanceDate;

        @JsonProperty("fechaPago")
        private LocalDateTime paymentDate;

        @JsonProperty("fechaPagoVencida")
        private boolean paymentDateExpired;

        @JsonProperty("monto")
        private double amount;

        @JsonProperty("motivoAnulacion")
        private String cancellationReason;

        @JsonProperty("motivoRepudioEmision")
        private String issuanceRepudiationReason;

        @JsonProperty("motivoDevolucion")
        private String returnReason;

        @JsonProperty("numeroChequera")
        private String checkbookNumber;

        @JsonProperty("rePresentar")
        private boolean rePresent;

        @JsonProperty("repudioEndoso")
        private boolean endorsementRepudiation;

        @JsonProperty("solicitandoAcuerdo")
        private boolean requestingAgreement;

        @JsonProperty("onp")
        private boolean onp;

        @JsonProperty("acuerdoRechazado")
        private boolean agreementRejected;

        @JsonProperty("fechaUltModif")
        private LocalDateTime lastModificationDate;

        @JsonProperty("cbuCustodia")
        private String custodyCbu;

        @JsonProperty("cbuDeposito")
        private String depositCbu;

        @JsonProperty("cuitSolicDevol")
        private String returnRequestCuit;

        @JsonProperty("beneficiarioFinalDocumentoTipo")
        private String finalBeneficiaryDocumentType;

        @JsonProperty("beneficiarioFinalDocumento")
        private String finalBeneficiaryDocument;

        @JsonProperty("nroLote")
        private String batchNumber;

        @JsonProperty("cedido")
        private boolean assigned;

        @JsonProperty("cesionPendiente")
        private boolean pendingAssignment;

        @JsonProperty("beneficiarioFinalNombre")
        private String finalBeneficiaryName;

        @JsonProperty("esUltimoEndosante")
        private boolean isLastEndorser;

        @JsonProperty("avalado")
        private boolean guaranteed;

        @JsonProperty("mandatoCobro")
        private boolean collectionMandate;

        @JsonProperty("mandatoNeg")
        private boolean negotiationMandate;

        @JsonProperty("esUltimoMandante")
        private boolean isLastMandator;

        @JsonProperty("ultimoEndosanteRazonSocial")
        private String lastEndorserBusinessName;

        @JsonProperty("cuentaEmisora")
        private CoelsaIssuingAccount issuingAccount;

        @JsonProperty("emitidoA")
        private CoelsaIssuedTo issuedTo;

        @JsonProperty("tenencia")
        private CoelsaTenure tenure;

        @JsonProperty("totalEndosos")
        private int totalEndorsements;

        @JsonProperty("endosos")
        private List<CoelsaEndorsement> endorsements;

        @JsonProperty("totalChqReferenciasPago")
        private int totalChequePaymentReferences;

        @JsonProperty("chqReferenciasPago")
        private List<CoelsaEcheqResponseGetPaymentReference> chequePaymentReferences;

        @JsonProperty("totalRechazos")
        private int totalRejections;

        @JsonProperty("rechazos")
        private List<CoelsaGetRejections> rejections;

        @JsonProperty("totalAvalistas")
        private int totalGuarantors;

        @JsonProperty("avalistas")
        private List<CoelsaGuarantor> guarantors;

        @JsonProperty("totalCesiones")
        private int totalAssignments;

        @JsonProperty("cesiones")
        private List<CoelsaAssignment> assignments;
    }

}