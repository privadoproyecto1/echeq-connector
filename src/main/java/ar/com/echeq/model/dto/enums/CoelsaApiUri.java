package ar.com.echeq.model.dto.enums;

import lombok.Getter;

@Getter
public enum CoelsaApiUri {
    GET_ECHEQ_BY_ID("apiEcheQ/Cheques/Cheque"),
    GET_ECHEQS("apiEcheQ/Cheques/ListaCheques"),
    REJECT_PAYMENT_INTERNAL_EXCHANGE("apiEcheQ/Cheques/Activo/RechazarPago"),
    REJECT_PAYMENT_OUTSIDE_CLEARING("apiEcheQ/Cheques/Activo/RechazarFueraCanje"),
    PAY_INTERNAL_CLEARING("/apiEcheQ/Cheques/Activo/Pagar");

    private final String value;

    CoelsaApiUri(String value) {
        this.value = value;
    }

}
