package ar.com.echeq.controller;

import ar.com.echeq.model.dto.EcheqDTO;
import ar.com.echeq.model.dto.request.GetEcheqsRequestDTO;
import ar.com.echeq.service.EcheqService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/echeqs")
public class EcheqController {
    private final EcheqService echeqService;

    @Autowired
    public EcheqController(EcheqService echeqService) {
        this.echeqService = echeqService;
    }

    @Operation(summary = "Get echeq information", description = "Retrieve information about a specific echeq by cuit and echeqId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved echeq",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EcheqDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Echeq not found",
                    content = @Content)})
    @GetMapping("/{cuit}/{echeqId}")
    public ResponseEntity<EcheqDTO> getEcheq(
            @NotNull @Parameter(in = ParameterIn.PATH, description = "CUIT of the echeq", required = true) @PathVariable String cuit,
            @NotNull @Parameter(in = ParameterIn.PATH, description = "ID of the echeq", required = true) @PathVariable("echeqId") String echeqId) {
        log.info("Getting echeq information");
        return ResponseEntity.ok(echeqService.getEcheq(cuit, echeqId));
    }

    @Operation(summary = "Get list of echeqs", description = "Retrieve a list of echeqs based on the provided request parameters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of echeqs",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EcheqDTO[].class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)})
    @GetMapping
    public ResponseEntity<List<EcheqDTO>> getEcheqs(
            @NotNull @Parameter(in = ParameterIn.QUERY, description = "Request parameters for fetching echeqs", required = true) @Valid @Validated GetEcheqsRequestDTO request) {
        log.info("Getting list of echeqs");
        return ResponseEntity.ok(echeqService.getEcheqs(request));
    }


}
