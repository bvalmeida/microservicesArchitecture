package br.com.fraud.controller;

import br.com.fraud.controller.request.FraudRequest;
import br.com.fraud.controller.response.FraudResponse;
import br.com.fraud.service.FraudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<FraudResponse> createFraud(@RequestBody FraudRequest fraudRequest){
        log.info("Calling controller to create fraud {}", fraudRequest);
        this.fraudService.createFraud(fraudRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "get isFraud", description = "get if isFraud")
    @ApiResponse(responseCode = "200", description = "get Fraud is success")
    @GetMapping("/is-fraud/{customerId}")
    public Boolean isFraud(@PathVariable("customerId") Long customerId){
        log.info("Calling controler to find all frauds {}");
        return this.fraudService.isFraud(customerId);
    }

    @Operation(summary = "find all frauds", description = "find all frauds")
    @ApiResponse(responseCode = "200", description = "find all frauds")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FraudResponse> listAllCustomer(){
        return this.fraudService.listAll();
    }
}
