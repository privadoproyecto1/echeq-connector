package ar.com.echeq.mapper;

import ar.com.echeq.connector.model.*;
import ar.com.echeq.model.dto.*;
import ar.com.echeq.model.dto.request.GetEcheqsRequestDTO;
import org.mapstruct.*;

import java.util.*;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface EcheqMapper {

    @Mapping(target = "filterString", expression = "java(toFilterString(dto))")
    @Mapping(target = "pagString", expression = "java(toPagString(dto))")
    @Mapping(target = "orderBy", constant = "cheques.fecha_pago")
    EcheqRequestMap toEcheqRequestMap(GetEcheqsRequestDTO dto);

    @Mapping(source = "groupId", target = "groupId")
    @Mapping(source = "certificateIssued", target = "certificateIssued")
    @Mapping(source = "agreedCheque", target = "agreedEcheq")
    @Mapping(source = "chequeCharacter", target = "echeqCharacter")
    @Mapping(source = "chequeConcept", target = "echeqConcept")
    @Mapping(source = "chequeId", target = "echeqId")
    @Mapping(source = "chequeMode", target = "echeqMode")
    @Mapping(source = "chequePaymentReason", target = "echeqPaymentReason")
    @Mapping(source = "chequeNumber", target = "echeqNumber")
    @Mapping(source = "chequeType", target = "echeqType")
    @Mapping(source = "cmc7", target = "cmc7")
    @Mapping(source = "visualizationCode", target = "visualizationCode")
    @Mapping(source = "issuanceCode", target = "issuanceCode")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "issuanceDate", target = "issuanceDate")
    @Mapping(source = "paymentDate", target = "paymentDate")
    @Mapping(source = "paymentDateExpired", target = "paymentDateExpired")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "cancellationReason", target = "cancellationReason")
    @Mapping(source = "issuanceRepudiationReason", target = "repudiationReason")
    @Mapping(source = "returnReason", target = "returnReason")
    @Mapping(source = "checkbookNumber", target = "echeqbookNumber")
    @Mapping(source = "rePresent", target = "rePresent")
    @Mapping(source = "endorsementRepudiation", target = "repudiationEndorsement")
    @Mapping(source = "requestingAgreement", target = "requestingAgreement")
    @Mapping(source = "onp", target = "onp")
    @Mapping(source = "agreementRejected", target = "agreementRejected")
    @Mapping(source = "lastModificationDate", target = "lastModificationDate")
    @Mapping(source = "custodyCbu", target = "custodyCbu")
    @Mapping(source = "depositCbu", target = "depositCbu")
    @Mapping(source = "returnRequestCuit", target = "returnRequestCuit")
    @Mapping(source = "finalBeneficiaryDocumentType", target = "finalBeneficiaryDocumentType")
    @Mapping(source = "finalBeneficiaryDocument", target = "finalBeneficiaryDocument")
    @Mapping(source = "batchNumber", target = "batchNumber")
    @Mapping(source = "assigned", target = "ceded")
    @Mapping(source = "pendingAssignment", target = "pendingCession")
    @Mapping(source = "finalBeneficiaryName", target = "finalBeneficiaryName")
    @Mapping(source = "lastEndorser", target = "lastEndorser")
    @Mapping(source = "guaranteed", target = "guaranteed")
    @Mapping(source = "collectionMandate", target = "collectionMandate")
    @Mapping(source = "negotiationMandate", target = "negotiationMandate")
    @Mapping(source = "lastMandator", target = "lastMandator")
    @Mapping(source = "lastEndorserBusinessName", target = "lastEndorserBusinessName")
    @Mapping(source = "issuingAccount", target = "issuingAccount", qualifiedByName = "mapCuentaEmisoraToAccountDTO")
    @Mapping(source = "issuedTo", target = "issuedTo", qualifiedByName = "mapEmitidoAToBeneficiaryDTO")
    @Mapping(source = "tenure", target = "holding", qualifiedByName = "mapTenenciaToBeneficiaryDTO")
    @Mapping(source = "totalEndorsements", target = "totalEndorsements")
    @Mapping(source = "endorsements", target = "endorsements", qualifiedByName = "mapEndososToEndorsementDTOs")
    @Mapping(source = "totalChequePaymentReferences", target = "totalEcheqPaymentReferences")
    @Mapping(source = "chequePaymentReferences", target = "echeqPaymentReferences", qualifiedByName = "mapChqReferenciasPagoToPaymentReferenceDTOs")
    @Mapping(source = "totalRejections", target = "totalRejections")
    @Mapping(source = "rejections", target = "rejections")
    @Mapping(source = "totalGuarantors", target = "totalGuarantors")
    @Mapping(source = "guarantors", target = "guarantors")
    @Mapping(source = "totalAssignments", target = "totalCessions")
    @Mapping(source = "assignments", target = "cessions")
    EcheqDTO toEcheqDTO(CoelsaEcheqsResponse.CoelsaEcheq coelsaEcheqResponse);

    @Mapping(source = "totalSigners", target = "totalSigners")
    @Mapping(source = "signers", target = "signers", qualifiedByName = "mapFirmantesToSigners")
    @Mapping(source = "groupId", target = "groupId")
    @Mapping(source = "certificateIssued", target = "certificateIssued")
    @Mapping(source = "agreedCheque", target = "agreedEcheq")
    @Mapping(source = "chequeCharacter", target = "echeqCharacter")
    @Mapping(source = "chequeConcept", target = "echeqConcept")
    @Mapping(source = "chequeId", target = "echeqId")
    @Mapping(source = "chequeMode", target = "echeqMode")
    @Mapping(source = "chequePaymentReason", target = "echeqPaymentReason")
    @Mapping(source = "chequeNumber", target = "echeqNumber")
    @Mapping(source = "chequeType", target = "echeqType")
    @Mapping(source = "cmc7", target = "cmc7")
    @Mapping(source = "visualizationCode", target = "visualizationCode")
    @Mapping(source = "issuanceCode", target = "issuanceCode")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "issuanceDate", target = "issuanceDate")
    @Mapping(source = "paymentDate", target = "paymentDate")
    @Mapping(source = "paymentDateExpired", target = "paymentDateExpired")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "cancellationReason", target = "cancellationReason")
    @Mapping(source = "issuanceRepudiationReason", target = "repudiationReason")
    @Mapping(source = "returnReason", target = "returnReason")
    @Mapping(source = "checkbookNumber", target = "echeqbookNumber")
    @Mapping(source = "rePresent", target = "rePresent")
    @Mapping(source = "endorsementRepudiation", target = "repudiationEndorsement")
    @Mapping(source = "requestingAgreement", target = "requestingAgreement")
    @Mapping(source = "onp", target = "onp")
    @Mapping(source = "agreementRejected", target = "agreementRejected")
    @Mapping(source = "lastModificationDate", target = "lastModificationDate")
    @Mapping(source = "custodyCbu", target = "custodyCbu")
    @Mapping(source = "depositCbu", target = "depositCbu")
    @Mapping(source = "returnRequestCuit", target = "returnRequestCuit")
    @Mapping(source = "finalBeneficiaryDocumentType", target = "finalBeneficiaryDocumentType")
    @Mapping(source = "finalBeneficiaryDocument", target = "finalBeneficiaryDocument")
    @Mapping(source = "batchNumber", target = "batchNumber")
    @Mapping(source = "assigned", target = "ceded")
    @Mapping(source = "pendingAssignment", target = "pendingCession")
    @Mapping(source = "finalBeneficiaryName", target = "finalBeneficiaryName")
    @Mapping(source = "lastEndorser", target = "lastEndorser")
    @Mapping(source = "guaranteed", target = "guaranteed")
    @Mapping(source = "collectionMandate", target = "collectionMandate")
    @Mapping(source = "negotiationMandate", target = "negotiationMandate")
    @Mapping(source = "lastMandator", target = "lastMandator")
    @Mapping(source = "lastEndorserBusinessName", target = "lastEndorserBusinessName")
    @Mapping(source = "issuingAccount", target = "issuingAccount", qualifiedByName = "mapCuentaEmisoraToAccountDTO")
    @Mapping(source = "issuedTo", target = "issuedTo", qualifiedByName = "mapEmitidoAToBeneficiaryDTO")
    @Mapping(source = "tenure", target = "holding", qualifiedByName = "mapTenenciaToBeneficiaryDTO")
    @Mapping(source = "totalEndorsements", target = "totalEndorsements")
    @Mapping(source = "endorsements", target = "endorsements", qualifiedByName = "mapEndososToEndorsementDTOs")
    @Mapping(source = "totalChequePaymentReferences", target = "totalEcheqPaymentReferences")
    @Mapping(source = "chequePaymentReferences", target = "echeqPaymentReferences", qualifiedByName = "mapChqReferenciasPagoToPaymentReferenceDTOs")
    @Mapping(source = "totalRejections", target = "totalRejections")
    @Mapping(source = "rejections", target = "rejections")
    @Mapping(source = "totalGuarantors", target = "totalGuarantors")
    @Mapping(source = "guarantors", target = "guarantors")
    @Mapping(source = "totalAssignments", target = "totalCessions")
    @Mapping(source = "assignments", target = "cessions")
    EcheqDTO toEcheqDTO(CoelsaEcheqResponse.CoelsaEcheq coelsaEcheq);

    List<EcheqDTO> toEcheqDTOList(List<CoelsaEcheqsResponse.CoelsaEcheq> coelsaEcheqs);

    @Named("mapFirmantesToSigners")
    default List<SignerDTO> mapFirmantesToSigners(List<CoelsaSigner> signers) {
        return signers.stream()
                .map(signer -> {
                    return SignerDTO.builder()
                            .document(signer.getDocument())
                            .documentType(signer.getDocumentType())
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Named("mapCuentaEmisoraToAccountDTO")
    default AccountDTO mapCuentaEmisoraToAccountDTO(CoelsaIssuingAccount issuingAccount) {
        return AccountDTO.builder()
                .bankCode(issuingAccount.getBankCode())
                .bankName(issuingAccount.getBankName())
                .issuerCbu(issuingAccount.getIssuerCbu())
                .issuerCp(issuingAccount.getIssuerCp())
                .issuerAccount(issuingAccount.getIssuerAccount())
                .issuerCuit(issuingAccount.getIssuerCuit())
                .issuerAddress(issuingAccount.getIssuerAddress())
                .issuerCurrency(issuingAccount.getIssuerCurrency())
                .issuerBusinessName(issuingAccount.getIssuerBusinessName())
                .issuerSubAccount(issuingAccount.getIssuerSubaccount())
                .branchCode(issuingAccount.getBranchCode())
                .branchCp(issuingAccount.getBranchCp())
                .branchAddress(issuingAccount.getBranchAddress())
                .branchName(issuingAccount.getBranchName())
                .branchProvince(issuingAccount.getBranchProvince())
                .build();
    }

    @Named("mapEmitidoAToBeneficiaryDTO")
    default BeneficiaryDTO mapEmitidoAToBeneficiaryDTO(CoelsaIssuedTo issuedTo) {
        return BeneficiaryDTO.builder()
                .beneficiaryDocument(issuedTo.getBeneficiaryDocument())
                .beneficiaryDocumentType(issuedTo.getBeneficiaryDocumentType())
                .beneficiaryName(issuedTo.getBeneficiaryName())
                .build();
    }

    @Named("mapTenenciaToBeneficiaryDTO")
    default BeneficiaryDTO mapTenenciaToBeneficiaryDTO(CoelsaTenure tenure) {
        return BeneficiaryDTO.builder()
                .beneficiaryDocument(tenure.getBeneficiaryDocument())
                .beneficiaryDocumentType(tenure.getBeneficiaryDocumentType())
                .beneficiaryName(tenure.getBeneficiaryName())
                .build();
    }

    @Named("mapEndososToEndorsementDTOs")
    default List<EndorsementDTO> mapEndososToEndorsementDTOs(List<CoelsaEndorsement> endorsements) {
        if (endorsements == null) {
            return new ArrayList<>();
        }
        return endorsements.stream()
                .map(endoso -> {
                    return EndorsementDTO.builder()
                            .beneficiaryDocument(endoso.getBeneficiaryDocument())
                            .beneficiaryDocumentType(endoso.getBeneficiaryDocumentType())
                            .beneficiaryBusinessName(endoso.getBeneficiaryBusinessName())
                            .issuerDocument(endoso.getIssuerDocument())
                            .issuerDocumentType(endoso.getIssuerDocumentType())
                            .issuerBusinessName(endoso.getIssuerBusinessName())
                            .endorsementStatus(endoso.getEndorsementStatus())
                            .dateTime(endoso.getDateTime())
                            .endorsementType(endoso.getEndorsementType())
                            .totalPaymentReferences(endoso.getTotalPaymentReferences())
                            .paymentReferences(mapReferenciasPagoToPaymentReferenceDTOs(endoso.getPaymentReferences()))
                            .build();
                })
                .collect(Collectors.toList());
    }

    default List<PaymentReferenceDTO> mapReferenciasPagoToPaymentReferenceDTOs(List<CoelsaPaymentReference> paymentReferences) {
        if (paymentReferences == null) {
            return new ArrayList<>();
        }
        return paymentReferences.stream()
                .map(paymentReference -> {
                    return PaymentReferenceDTO.builder()
                            .reference(paymentReference.getReference())
                            .value(paymentReference.getValue())
                            .build();
                })
                .collect(Collectors.toList());
    }
    @Named("mapChqReferenciasPagoToPaymentReferenceDTOs")
    default List<PaymentReferenceDTO> mapChqReferenciasPagoToPaymentReferenceDTOs(List<CoelsaEcheqResponseGetPaymentReference> chequePaymentReferences) {
        if (chequePaymentReferences == null) {
            return new ArrayList<>();
        }
        return chequePaymentReferences.stream()
                .map(chequePaymentReference -> {
                    return PaymentReferenceDTO.builder()
                            .reference(chequePaymentReference.getReference())
                            .value(chequePaymentReference.getValue())
                            .build();
                })
                .collect(Collectors.toList());
    }

    default String toFilterString(GetEcheqsRequestDTO dto) {
        Map<String, String> filters = new HashMap<>();
        if (Objects.nonNull(dto.getCuit())) filters.put("cuit", dto.getCuit());
        if (Objects.nonNull(dto.getStatus())) filters.put("estado", dto.getStatus().name());
        if (Objects.nonNull(dto.getEcheqNumber())) filters.put("cheque_numero", dto.getEcheqNumber());
        if (Objects.nonNull(dto.getIssuerCuit())) filters.put("cuenta_emisora.emisor_cuit", dto.getIssuerCuit());
        if (Objects.nonNull(dto.getIssuerCbu())) filters.put("cuenta_emisora.emisor_cbu", dto.getIssuerCbu());
        if (Objects.nonNull(dto.getBeneficiaryDocument()))
            filters.put("emitido_a.beneficiario_documento", dto.getBeneficiaryDocument());
        if (Objects.nonNull(dto.getEndorsedToCuit())) filters.put("endosado_a", dto.getEndorsedToCuit().toString());
        if (Objects.nonNull(dto.getEndorsedByCuit())) filters.put("endosado_por", dto.getEndorsedByCuit().toString());
        if (Objects.nonNull(dto.getIssuanceDate())) filters.put("fecha_emision", dto.getIssuanceDate().toString());
        if (Objects.nonNull(dto.getIssuanceDateFrom())) filters.put("fecha_emision_desde", dto.getIssuanceDateFrom().toString());
        if (Objects.nonNull(dto.getIssuanceDateTo())) filters.put("fecha_emision_hasta", dto.getIssuanceDateTo().toString());
        if (Objects.nonNull(dto.getPaymentDate())) filters.put("fecha_pago", dto.getPaymentDate().toString());
        if (Objects.nonNull(dto.getPaymentDateFrom())) filters.put("fecha_pago_desde", dto.getPaymentDateFrom().toString());
        if (Objects.nonNull(dto.getPaymentDateTo())) filters.put("fecha_pago_hasta", dto.getPaymentDateTo().toString());

        StringJoiner filterJoiner = new StringJoiner(" and ");
        filters.forEach((key, value) -> filterJoiner.add(key + " eq __" + value + "__"));

        return filterJoiner.toString();
    }

    default String toPagString(GetEcheqsRequestDTO dto) {
        return "cheques:" + (dto.getPage() != null ? dto.getPage() : "1") + "-" + (dto.getItems() != null ? dto.getItems() : "10");
    }

}