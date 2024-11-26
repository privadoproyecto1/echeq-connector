package ar.com.echeq.model.dto.enums;

public enum EcheqState {
    ACTIVE("ACTIVO"),
    ACTIVE_PENDING("ACTIVO-PENDIENTE"),
    CANCELED("ANULADO"),
    CUSTODY("CUSTODIA"),
    DEPOSITED("DEPOSITADO"),
    RETURN_PENDING("DEVOLUCION-PENDIENTE"),
    ISSUED_PENDING("EMITIDO-PENDIENTE"),
    PAID("PAGADO"),
    INTRODUCED("PRESENTADO"),
    REJECTED("RECHAZADO"),
    DISOWNED("REPUDIADO"),
    EXPIRED("CADUCADO"),
    NEGOTIATION_PENDING("NEGOCIACIÓN-PENDIENTE"),
    NEGOTIATION("NEGOCIACIÓN"),
    ASSIGNMENT_PENDING("CESION-PENDIENTE"),
    ENDORSEMENT_PENDING("AVAL-PENDIENTE"),
    MANDATE_PENDING("MANDATO-PENDIENTE");

    private final String value;

    EcheqState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
