package ar.com.echeq.service;

import ar.com.echeq.connector.CoelsaClientConnector;
import ar.com.echeq.exception.CoelsaPaymentRejectException;
import ar.com.echeq.mapper.EcheqPaymentsMapper;
import ar.com.echeq.model.dto.request.EcheqInternalClearingDTO;
import ar.com.echeq.model.dto.request.InternalClearingDTO;
import ar.com.echeq.model.dto.request.RejectPaymentDTO;
import ar.com.echeq.model.dto.request.RejectPaymentOutsideDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EcheqPaymentService {

    private final EcheqPaymentsMapper echeqPaymentsMapper;
    private final CoelsaClientConnector coelsaClientConnector;

    public EcheqPaymentService(EcheqPaymentsMapper echeqPaymentsMapper,
                               CoelsaClientConnector coelsaClientConnector) {
        this.echeqPaymentsMapper = echeqPaymentsMapper;
        this.coelsaClientConnector = coelsaClientConnector;
    }



    private String buildFilterString(String cuit, String echeqId) {
        return String.format("cuit eq '%s' and cheque.cheque_id eq '%s'", cuit, echeqId);
    }

    private String buildDefaultSelect(){
        return "cheque, cheque.rechazos, cheque.cesiones, cheque.avalistas, cheque.endosos, cheque.chq_referencias_pago";
    }

    public void rejectPayment(RejectPaymentDTO rejectPaymentDTO) {

        var coelsaRejectPaymentDTO = echeqPaymentsMapper.toCoelsaRejectedPayment(rejectPaymentDTO);

        var coelsaEcheqResponse = Optional.ofNullable(coelsaClientConnector.rejectPayment(coelsaRejectPaymentDTO))
                .orElseThrow(() -> new RuntimeException("No response from Coelsa"));

        var responseCode = coelsaEcheqResponse.getResponse().stream()
                .findFirst()
                .map(response -> response.getResponse().getCode())
                .orElseThrow(() -> new RuntimeException("Invalid response structure"));

        if (!"0000".equals(responseCode)) {
            throw new CoelsaPaymentRejectException("Error rejecting payment: " + responseCode);
        }
    }

    public void rejectOutsideClearing(RejectPaymentOutsideDTO rejectPaymentOutsideDTO) {

        var coelsaRejectPayment = echeqPaymentsMapper.toCoelsaRejectOutsideClearing(rejectPaymentOutsideDTO);

        var coelsaEcheqResponse = Optional.ofNullable(coelsaClientConnector.rejectOutsideClearing(coelsaRejectPayment))
                .orElseThrow(() -> new RuntimeException("No response from Coelsa"));

        var responseCode = coelsaEcheqResponse.getResponse().stream()
                .findFirst()
                .map(response -> response.getResponse().getCode())
                .orElseThrow(() -> new RuntimeException("Invalid response structure"));

        if (!"0000".equals(responseCode)) {
            throw new CoelsaPaymentRejectException("Error rejecting outside clearing: " + responseCode);
        }
    }

    public void payInternalClearing(EcheqInternalClearingDTO echeqInternalClearingDTO) {

        var coelsaInternalClearing = echeqPaymentsMapper.toCoelsaPayInternalClearing(echeqInternalClearingDTO);

        var coelsaEcheqResponse = Optional.ofNullable(coelsaClientConnector.payInternalClearing(coelsaInternalClearing))
                .orElseThrow(() -> new RuntimeException("No response from Coelsa"));

        var responseCode = coelsaEcheqResponse.getResponse().stream()
                .findFirst()
                .map(response -> response.getResponse().getCode())
                .orElseThrow(() -> new RuntimeException("Invalid response structure"));

        if (!"0000".equals(responseCode)) {
            throw new CoelsaPaymentRejectException("Error paying internal clearing: " + responseCode);
        }

    }
}
