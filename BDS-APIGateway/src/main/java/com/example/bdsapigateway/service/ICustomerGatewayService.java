package com.example.bdsapigateway.service;

import com.example.bdsapigateway.modelDTO.Customer;
import reactor.core.publisher.Flux;

public interface ICustomerGatewayService {
    Flux<Customer> findAllCustomer();
}
