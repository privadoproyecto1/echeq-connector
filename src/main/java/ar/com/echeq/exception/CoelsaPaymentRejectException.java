package ar.com.echeq.exception;

public class CoelsaPaymentRejectException extends RuntimeException {
    public CoelsaPaymentRejectException(String errorRejectingPayment) {
        super(errorRejectingPayment);
    }
}
