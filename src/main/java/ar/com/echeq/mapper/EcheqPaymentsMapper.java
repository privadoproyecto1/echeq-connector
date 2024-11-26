package ar.com.echeq.mapper;

import ar.com.echeq.connector.model.*;
import ar.com.echeq.model.dto.SignerDTO;
import ar.com.echeq.model.dto.request.*;
import org.mapstruct.*;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface EcheqPaymentsMapper {
    @Mapping(source = "paymentType", target = "paymentType")
    @Mapping(source = "rejection", target = "rejections", qualifiedByName = "mapRejectionToRejections")
    @Mapping(source = "signer", target = "signers", qualifiedByName = "mapSignerToSigners")
    CoelsaRejectPayment toCoelsaRejectedPayment(RejectPaymentDTO rejectPaymentDTO);

    @Mapping(source = "rejection", target = "rejections", qualifiedByName = "mapRejectionToRejections")
    @Mapping(source = "signer", target = "signers", qualifiedByName = "mapSignerToSigners")
    CoelsaRejectOutsideClearing toCoelsaRejectOutsideClearing(RejectPaymentOutsideDTO rejectPaymentOutsideDTO);

    @Mapping(source = "paymentType", target = "paymentType")
    @Mapping(source = "payment", target = "payments", qualifiedByName = "mapPaymentToPayments")
    @Mapping(source = "signer", target = "signers", qualifiedByName = "mapSignerToSigners")
    CoelsaPayInternalClearing toCoelsaPayInternalClearing(EcheqInternalClearingDTO internalClearingDTO);

    @Mapping(source = "echeqId", target = "echeqId")
    @Mapping(source = "rejectionCode", target = "rejectionCode")
    CoelsaRejection toCoelsaRejection(PaymentRejectionDTO paymentRejectionDTO);

    @Mapping(source = "documentType", target = "documentType")
    @Mapping(source = "document", target = "document")
    CoelsaSigner toCoelsaSigner(SignerDTO signerDTO);

    @Mapping(source = "echeqId", target = "echeqId")
    @Mapping(source = "beneficiaryDocumentType", target = "beneficiaryDocumentType")
    @Mapping(source = "beneficiaryDocument", target = "beneficiaryDocument")
    CoelsaPayment toCoelsaPayment(InternalClearingDTO internalClearingDTO);

    @Named("mapRejectionToRejections")
    default List<CoelsaRejection> mapRejectionToRejections(PaymentRejectionDTO rejection) {
        if (rejection == null) {
            return Collections.emptyList();
        }
        return List.of(toCoelsaRejection(rejection));
    }

    @Named("mapSignerToSigners")
    default List<CoelsaSigner> mapRejectionToRejections(SignerDTO signer) {
        if (signer == null) {
            return Collections.emptyList();
        }
        return List.of(toCoelsaSigner(signer));
    }

    @Named("mapPaymentToPayments")
    default List<CoelsaPayment> mapPaymentToPayments(InternalClearingDTO internalClearingDTO) {
        if (internalClearingDTO == null) {
            return Collections.emptyList();
        }
        return List.of(toCoelsaPayment(internalClearingDTO));
    }

}
