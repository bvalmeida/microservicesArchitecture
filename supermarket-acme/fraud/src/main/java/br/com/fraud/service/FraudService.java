package br.com.fraud.service;

import br.com.fraud.controller.request.FraudRequest;
import br.com.fraud.controller.response.FraudResponse;

import java.util.List;

public interface FraudService {

    FraudResponse createFraud(FraudRequest fraudRequest);
    boolean isFraud(Long customerId);
    List<FraudResponse> listAll();

}
