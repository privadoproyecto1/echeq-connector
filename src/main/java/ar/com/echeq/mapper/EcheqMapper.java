package ar.com.echeq.mapper;

import ar.com.echeq.connector.model.CoelsaEcheq;
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

    @Mapping(source = "cheque.totalFirmantes", target = "totalSigners")
    @Mapping(source = "cheque.firmantes", target = "signers", qualifiedByName = "mapFirmantesToSigners")
    @Mapping(source = "cheque.agrupadorId", target = "groupId")
    @Mapping(source = "cheque.certificadoEmitido", target = "certificateIssued")
    @Mapping(source = "cheque.chequeAcordado", target = "agreedEcheq")
    @Mapping(source = "cheque.chequeCaracter", target = "echeqCharacter")
    @Mapping(source = "cheque.chequeConcepto", target = "echeqConcept")
    @Mapping(source = "cheque.chequeId", target = "echeqId")
    @Mapping(source = "cheque.chequeModo", target = "echeqMode")
    @Mapping(source = "cheque.chequeMotivoPago", target = "echeqPaymentReason")
    @Mapping(source = "cheque.chequeNumero", target = "echeqNumber")
    @Mapping(source = "cheque.chequeTipo", target = "echeqType")
    @Mapping(source = "cheque.cmc7", target = "cmc7")
    @Mapping(source = "cheque.codVisualizacion", target = "visualizationCode")
    @Mapping(source = "cheque.codigoEmision", target = "issuanceCode")
    @Mapping(source = "cheque.estado", target = "status")
    @Mapping(source = "cheque.fechaEmision", target = "issuanceDate")
    @Mapping(source = "cheque.fechaPago", target = "paymentDate")
    @Mapping(source = "cheque.fechaPagoVencida", target = "paymentDateExpired")
    @Mapping(source = "cheque.monto", target = "amount")
    @Mapping(source = "cheque.motivoAnulacion", target = "cancellationReason")
    @Mapping(source = "cheque.motivoRepudioEmision", target = "repudiationReason")
    @Mapping(source = "cheque.motivoDevolucion", target = "returnReason")
    @Mapping(source = "cheque.numeroChequera", target = "echeqbookNumber")
    @Mapping(source = "cheque.rePresentar", target = "rePresent")
    @Mapping(source = "cheque.repudioEndoso", target = "repudiationEndorsement")
    @Mapping(source = "cheque.solicitandoAcuerdo", target = "requestingAgreement")
    @Mapping(source = "cheque.onp", target = "onp")
    @Mapping(source = "cheque.acuerdoRechazado", target = "agreementRejected")
    @Mapping(source = "cheque.fechaUltModif", target = "lastModificationDate")
    @Mapping(source = "cheque.cbuCustodia", target = "custodyCbu")
    @Mapping(source = "cheque.cbuDeposito", target = "depositCbu")
    @Mapping(source = "cheque.cuitSolicDevol", target = "returnRequestCuit")
    @Mapping(source = "cheque.beneficiarioFinalDocumentoTipo", target = "finalBeneficiaryDocumentType")
    @Mapping(source = "cheque.beneficiarioFinalDocumento", target = "finalBeneficiaryDocument")
    @Mapping(source = "cheque.nroLote", target = "batchNumber")
    @Mapping(source = "cheque.cedido", target = "ceded")
    @Mapping(source = "cheque.cesionPendiente", target = "pendingCession")
    @Mapping(source = "cheque.beneficiarioFinalNombre", target = "finalBeneficiaryName")
    @Mapping(source = "cheque.esUltimoEndosante", target = "lastEndorser")
    @Mapping(source = "cheque.avalado", target = "guaranteed")
    @Mapping(source = "cheque.mandatoCobro", target = "collectionMandate")
    @Mapping(source = "cheque.mandatoNeg", target = "negotiationMandate")
    @Mapping(source = "cheque.esUltimoMandante", target = "lastMandator")
    @Mapping(source = "cheque.ultimoEndosanteRazonSocial", target = "lastEndorserBusinessName")
    @Mapping(source = "cheque.cuentaEmisora", target = "issuingAccount", qualifiedByName = "mapCuentaEmisoraToAccountDTO")
    @Mapping(source = "cheque.emitidoA", target = "issuedTo", qualifiedByName = "mapEmitidoAToBeneficiaryDTO")
    @Mapping(source = "cheque.tenencia", target = "holding", qualifiedByName = "mapTenenciaToBeneficiaryDTO")
    @Mapping(source = "cheque.totalEndosos", target = "totalEndorsements")
    @Mapping(source = "cheque.endosos", target = "endorsements", qualifiedByName = "mapEndososToEndorsementDTOs")
    @Mapping(source = "cheque.totalChqReferenciasPago", target = "totalEcheqPaymentReferences")
    @Mapping(source = "cheque.chqReferenciasPago", target = "echeqPaymentReferences", qualifiedByName = "mapChqReferenciasPagoToPaymentReferenceDTOs")
    @Mapping(source = "cheque.totalRechazos", target = "totalRejections")
    @Mapping(source = "cheque.rechazos", target = "rejections")
    @Mapping(source = "cheque.totalAvalistas", target = "totalGuarantors")
    @Mapping(source = "cheque.avalistas", target = "guarantors")
    @Mapping(source = "cheque.totalCesiones", target = "totalCessions")
    @Mapping(source = "cheque.cesiones", target = "cessions")
    EcheqDTO toEcheqDTO(CoelsaEcheq coelsaEcheq);

    List<EcheqDTO> toEcheqListDTO(List<CoelsaEcheq> coelsaEcheqs);


    @Named("mapFirmantesToSigners")
    default List<SignerDTO> mapFirmantesToSigners(List<CoelsaEcheq.Firmante> firmantes) {
        return firmantes.stream()
                .map(firmante -> {
                    return SignerDTO.builder()
                            .document(firmante.getDocumento())
                            .documentType(firmante.getDocumentoTipo())
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Named("mapCuentaEmisoraToAccountDTO")
    default AccountDTO mapCuentaEmisoraToAccountDTO(CoelsaEcheq.CuentaEmisora cuentaEmisora) {
        return AccountDTO.builder()
                .bankCode(cuentaEmisora.getBancoCodigo())
                .bankName(cuentaEmisora.getBancoNombre())
                .issuerCbu(cuentaEmisora.getEmisorCbu())
                .issuerCp(cuentaEmisora.getEmisorCp())
                .issuerAccount(cuentaEmisora.getEmisorCuenta())
                .issuerCuit(cuentaEmisora.getEmisorCuit())
                .issuerAddress(cuentaEmisora.getEmisorDomicilio())
                .issuerCurrency(cuentaEmisora.getEmisorMoneda())
                .issuerBusinessName(cuentaEmisora.getEmisorRazonSocial())
                .issuerSubAccount(cuentaEmisora.getEmisorSubcuenta())
                .branchCode(cuentaEmisora.getSucursalCodigo())
                .branchCp(cuentaEmisora.getSucursalCp())
                .branchAddress(cuentaEmisora.getSucursalDomicilio())
                .branchName(cuentaEmisora.getSucursalNombre())
                .branchProvince(cuentaEmisora.getSucursalProvincia())
                .build();
    }

    @Named("mapEmitidoAToBeneficiaryDTO")
    default BeneficiaryDTO mapEmitidoAToBeneficiaryDTO(CoelsaEcheq.EmitidoA emitidoA) {
        return BeneficiaryDTO.builder()
                .beneficiaryDocument(emitidoA.getBeneficiarioDocumento())
                .beneficiaryDocumentType(emitidoA.getBeneficiarioDocumentoTipo())
                .beneficiaryName(emitidoA.getBeneficiarioNombre())
                .build();
    }

    @Named("mapTenenciaToBeneficiaryDTO")
    default BeneficiaryDTO mapTenenciaToBeneficiaryDTO(CoelsaEcheq.Tenencia tenencia) {
        return BeneficiaryDTO.builder()
                .beneficiaryDocument(tenencia.getBeneficiarioDocumento())
                .beneficiaryDocumentType(tenencia.getBeneficiarioDocumentoTipo())
                .beneficiaryName(tenencia.getBeneficiarioNombre())
                .build();
    }

    @Named("mapEndososToEndorsementDTOs")
    default List<EndorsementDTO> mapEndososToEndorsementDTOs(List<CoelsaEcheq.Endoso> endosos) {
        return endosos.stream()
                .map(endoso -> {
                    return EndorsementDTO.builder()
                            .beneficiaryDocument(endoso.getBenefDocumento())
                            .beneficiaryDocumentType(endoso.getBenefDocumentoTipo())
                            .beneficiaryBusinessName(endoso.getBenefRazonSocial())
                            .issuerDocument(endoso.getEmisorDocumento())
                            .issuerDocumentType(endoso.getEmisorDocumentoTipo())
                            .issuerBusinessName(endoso.getEmisorRazonSocial())
                            .endorsementStatus(endoso.getEstadoEndoso())
                            .dateTime(endoso.getFechaHora())
                            .endorsementType(endoso.getTipoEndoso())
                            .totalPaymentReferences(endoso.getTotalReferenciasPago())
                            .paymentReferences(mapReferenciasPagoToPaymentReferenceDTOs(endoso.getReferenciasPago()))
                            .build();
                })
                .collect(Collectors.toList());
    }

    default List<PaymentReferenceDTO> mapReferenciasPagoToPaymentReferenceDTOs(List<CoelsaEcheq.ReferenciaPago> referenciasPago) {
        return referenciasPago.stream()
                .map(referenciaPago -> {
                    return PaymentReferenceDTO.builder()
                            .reference(referenciaPago.getReferencia())
                            .value(referenciaPago.getValor())
                            .build();
                })
                .collect(Collectors.toList());
    }
    @Named("mapChqReferenciasPagoToPaymentReferenceDTOs")
    default List<PaymentReferenceDTO> mapChqReferenciasPagoToPaymentReferenceDTOs(List<CoelsaEcheq.ChqReferenciaPago> chqReferenciasPago) {
        return chqReferenciasPago.stream()
                .map(chqReferenciaPago -> {
                    return PaymentReferenceDTO.builder()
                            .reference(chqReferenciaPago.getReferencia())
                            .value(chqReferenciaPago.getValor())
                            .build();
                })
                .collect(Collectors.toList());
    }

    default String toFilterString(GetEcheqsRequestDTO dto) {
        Map<String, String> filters = new HashMap<>();
        if (Objects.nonNull(dto.getCuit())) filters.put("cheques.cuit", dto.getCuit());
        if (Objects.nonNull(dto.getStatus())) filters.put("cheques.estado", dto.getStatus().name());
        if (Objects.nonNull(dto.getEcheqNumber())) filters.put("cheques.cheque_numero", dto.getEcheqNumber());
        if (Objects.nonNull(dto.getIssuerCuit())) filters.put("cheques.cuenta_emisora.emisor_cuit", dto.getIssuerCuit());
        if (Objects.nonNull(dto.getIssuerCbu())) filters.put("cheques.cuenta_emisora.emisor_cbu", dto.getIssuerCbu());
        if (Objects.nonNull(dto.getBeneficiaryDocument()))
            filters.put("cheques.emitido_a.beneficiario_documento", dto.getBeneficiaryDocument());
        if (Objects.nonNull(dto.getEndorsedToCuit())) filters.put("cheques.endosado_a", dto.getEndorsedToCuit().toString());
        if (Objects.nonNull(dto.getEndorsedByCuit())) filters.put("cheques.endosado_por", dto.getEndorsedByCuit().toString());
        if (Objects.nonNull(dto.getIssuanceDate())) filters.put("cheques.fecha_emision", dto.getIssuanceDate().toString());
        if (Objects.nonNull(dto.getIssuanceDateFrom())) filters.put("cheques.fecha_emision_desde", dto.getIssuanceDateFrom().toString());
        if (Objects.nonNull(dto.getIssuanceDateTo())) filters.put("cheques.fecha_emision_hasta", dto.getIssuanceDateTo().toString());
        if (Objects.nonNull(dto.getPaymentDate())) filters.put("cheques.fecha_pago", dto.getPaymentDate().toString());
        if (Objects.nonNull(dto.getPaymentDateFrom())) filters.put("cheques.fecha_pago_desde", dto.getPaymentDateFrom().toString());
        if (Objects.nonNull(dto.getPaymentDateTo())) filters.put("cheques.fecha_pago_hasta", dto.getPaymentDateTo().toString());

        StringJoiner filterJoiner = new StringJoiner(" and ");
        filters.forEach((key, value) -> filterJoiner.add(key + " eq '" + value + "'"));

        return filterJoiner.toString();
    }

    default String toPagString(GetEcheqsRequestDTO dto) {
        return "cheques:" + (dto.getPage() != null ? dto.getPage() : "1") + "-" + (dto.getItems() != null ? dto.getItems() : "10");
    }

}