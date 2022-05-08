package br.com.fraud.service;

import br.com.fraud.controller.request.FraudRequest;
import br.com.fraud.controller.response.FraudResponse;

public interface FraudService {

    FraudResponse createFraud(FraudRequest fraudRequest);
    boolean isFraud(Long customerId);

}
