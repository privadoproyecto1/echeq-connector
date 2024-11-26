package ar.com.echeq.controller;

import ar.com.echeq.model.dto.request.EcheqInternalClearingDTO;
import ar.com.echeq.model.dto.request.RejectPaymentDTO;
import ar.com.echeq.model.dto.request.RejectPaymentOutsideDTO;
import ar.com.echeq.service.EcheqPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/v1/payments")
public class EcheqPaymentController {

    private final EcheqPaymentService echeqPaymentService;

    @Autowired
    public EcheqPaymentController(EcheqPaymentService echeqPaymentService) {
        this.echeqPaymentService = echeqPaymentService;
    }

    @Operation(summary = "Reject payment")
    @PostMapping("/reject")
    public ResponseEntity<Void> rejectPayment(@RequestBody RejectPaymentDTO content) {
        log.info("Rejecting payment");
        echeqPaymentService.rejectPayment(content);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Reject payment outside clearing")
    @PostMapping("/reject-outside-clearing")
    public ResponseEntity<Void> rejectOutsideClearing(@RequestBody RejectPaymentOutsideDTO content) {
        log.info("Rejecting payment outside clearing");
        echeqPaymentService.rejectOutsideClearing(content);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Pay internal clearing")
    @PostMapping("/pay")
    public ResponseEntity<Void> payInternalClearing(@RequestBody EcheqInternalClearingDTO content) {
        log.info("Paying internal clearing");
        echeqPaymentService.payInternalClearing(content);
        return ResponseEntity.ok().build();
    }
}