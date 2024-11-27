package ar.com.echeq.service;

import ar.com.echeq.connector.CoelsaClientConnector;
import ar.com.echeq.connector.model.CoelsaEcheqResponse;
import ar.com.echeq.mapper.EcheqMapper;
import ar.com.echeq.model.dto.EcheqDTO;
import ar.com.echeq.model.dto.request.GetEcheqsRequestDTO;
import ar.com.echeq.mapper.EcheqRequestMap;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class EcheqService {

    private final EcheqMapper echeqMapper;
    private final CoelsaClientConnector coelsaClientConnector;

    public EcheqService(EcheqMapper echeqMapper,
                        CoelsaClientConnector coelsaClientConnector) {
        this.echeqMapper = echeqMapper;
        this.coelsaClientConnector = coelsaClientConnector;
    }


    public EcheqDTO getEcheq(String cuit, String echeqId) {

        String filterString = buildFilterString(cuit, echeqId);

        CoelsaEcheqResponse coelsaEcheqResponse = coelsaClientConnector.getEcheq(filterString, buildDefaultSelect());

        return echeqMapper.toEcheqDTO(coelsaEcheqResponse.getCoelsaEcheq());
    }

    public Flux<EcheqDTO> getEcheqs(GetEcheqsRequestDTO request) {

        EcheqRequestMap echeqRequestMap = echeqMapper.toEcheqRequestMap(request);

        return coelsaClientConnector.getEcheqs(
                        echeqRequestMap.getFilterString(),
                        echeqRequestMap.getPagString(),
                        echeqRequestMap.getOrderBy(),
                        request.getSelect())
                .flatMap(response -> Flux.fromIterable(echeqMapper.toEcheqDTOList(response.getCoelsaEcheq())));
    }

    private String buildFilterString(String cuit, String echeqId) {
        return String.format("cuit eq '%s' and cheque.cheque_id eq '%s'", cuit, echeqId);
    }

    private String buildDefaultSelect(){
        return "cheque, cheque.rechazos, cheque.cesiones, cheque.avalistas, cheque.endosos, cheque.chq_referencias_pago";
    }

}
