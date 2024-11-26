package ar.com.echeq.mapper;

import lombok.Data;

@Data
public class EcheqRequestMap {
    private String filterString;
    private String pagString;
    private String orderBy;
}