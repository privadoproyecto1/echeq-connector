package ar.com.echeq.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDTO {
    private String bankCode;
    private String bankName;
    private String issuerCbu;
    private String issuerCp;
    private String issuerAccount;
    private String issuerCuit;
    private String issuerAddress;
    private String issuerCurrency;
    private String issuerBusinessName;
    private String issuerSubAccount;
    private String branchCode;
    private String branchCp;
    private String branchAddress;
    private String branchName;
    private String branchProvince;
}