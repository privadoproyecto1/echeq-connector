package ar.com.echeq.model.dto.request;

import ar.com.echeq.model.dto.enums.EcheqState;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Data
public class GetEcheqsRequestDTO {
    @NotNull
    @Size(min = 1)
    private String cuit;

    private EcheqState status;
    private String echeqNumber;
    private String issuerCuit;
    private String issuerCbu;
    private String beneficiaryDocument;
    private Date endorsedToCuit;
    private Date endorsedByCuit;
    private Date issuanceDate;
    private Date issuanceDateFrom;
    private Date issuanceDateTo;
    private Date paymentDate;
    private Date paymentDateFrom;
    private Date paymentDateTo;
    private String page;
    private String items;
    private String select = "cheque, cheque.rechazos, cheque.cesiones, cheque.avalistas, cheque.endosos, cheque.chq_referencias_pago";
}