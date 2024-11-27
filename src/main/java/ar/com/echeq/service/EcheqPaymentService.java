package ar.com.echeq.service;

import ar.com.echeq.connector.CoelsaClientConnector;
import ar.com.echeq.connector.model.CoelsaEcheqPaymentsResponse;
import ar.com.echeq.exception.CoelsaPaymentRejectException;
import ar.com.echeq.mapper.EcheqPaymentsMapper;
import ar.com.echeq.model.dto.request.EcheqInternalClearingDTO;
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

    public void rejectPayment(RejectPaymentDTO rejectPaymentDTO) {
        var coelsaRejectPaymentDTO = echeqPaymentsMapper.toCoelsaRejectedPayment(rejectPaymentDTO);
        handleResponse(coelsaClientConnector.rejectPayment(coelsaRejectPaymentDTO), "Error rejecting payment: ");
    }

    public void rejectOutsideClearing(RejectPaymentOutsideDTO rejectPaymentOutsideDTO) {
        var coelsaRejectPayment = echeqPaymentsMapper.toCoelsaRejectOutsideClearing(rejectPaymentOutsideDTO);
        handleResponse(coelsaClientConnector.rejectOutsideClearing(coelsaRejectPayment), "Error rejecting outside clearing: ");
    }

    public void payInternalClearing(EcheqInternalClearingDTO echeqInternalClearingDTO) {
        var coelsaInternalClearing = echeqPaymentsMapper.toCoelsaPayInternalClearing(echeqInternalClearingDTO);
        handleResponse(coelsaClientConnector.payInternalClearing(coelsaInternalClearing), "Error paying internal clearing: ");
    }

    private void handleResponse(CoelsaEcheqPaymentsResponse response, String errorMessage) {
        var responseCode = getResponseCode(response);
        validateResponseCode(responseCode, errorMessage);
    }

    private String getResponseCode(CoelsaEcheqPaymentsResponse coelsaEcheqPaymentsResponse) {
        return Optional.ofNullable(coelsaEcheqPaymentsResponse).orElseThrow(() -> new RuntimeException("No response from Coelsa"))
                .getResponse().stream()
                .findFirst()
                .map(response -> response.getResponse().getCode())
                .orElseThrow(() -> new RuntimeException("Invalid response structure"));
    }

    private void validateResponseCode(String responseCode, String errorMessage) {
        if (!"0000".equals(responseCode)) {
            throw new CoelsaPaymentRejectException(errorMessage + responseCode);
        }
    }
}