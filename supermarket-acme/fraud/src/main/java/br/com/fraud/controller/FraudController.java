package br.com.fraud.controller;

import br.com.fraud.controller.response.FraudResponse;
import br.com.fraud.service.FraudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/frauds")
@Tag(name = "Api to management frauds", description = "Create and management frauds")
public class FraudController {

    private final FraudService fraudService;

    public FraudController(FraudService fraudService) {
        this.fraudService = fraudService;
    }

    @Operation(summary = "create fraud", description = "create fraud")
    @ApiResponse(responseCode = "201", description = "Fraud success created")
    @PostMapping
    public ResponseEntity<FraudResponse> createFraud(@RequestBody FraudResponse fraudResponse){
        return null; //TODO Implementar um post
    }

    //TODO get fraud
}
