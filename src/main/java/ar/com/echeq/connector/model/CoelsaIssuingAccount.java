package ar.com.echeq.connector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoelsaIssuingAccount {
    @JsonProperty("banco_codigo")
    private String bankCode;

    @JsonProperty("banco_nombre")
    private String bankName;

    @JsonProperty("emisor_cbu")
    private String issuerCbu;

    @JsonProperty("emisor_cp")
    private String issuerCp;

    @JsonProperty("emisor_cuenta")
    private String issuerAccount;

    @JsonProperty("emisor_cuit")
    private String issuerCuit;

    @JsonProperty("emisor_domicilio")
    private String issuerAddress;

    @JsonProperty("emisor_moneda")
    private String issuerCurrency;

    @JsonProperty("emisor_razon_social")
    private String issuerBusinessName;

    @JsonProperty("emisor_subcuenta")
    private String issuerSubaccount;

    @JsonProperty("sucursal_codigo")
    private String branchCode;

    @JsonProperty("sucursal_cp")
    private String branchCp;

    @JsonProperty("sucursal_domicilio")
    private String branchAddress;

    @JsonProperty("sucursal_nombre")
    private String branchName;

    @JsonProperty("sucursal_provincia")
    private String branchProvince;
}

