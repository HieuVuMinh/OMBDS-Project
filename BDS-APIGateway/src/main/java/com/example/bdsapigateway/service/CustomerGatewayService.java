package com.example.bdsapigateway.service;

import com.example.bdsapigateway.modelDTO.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class CustomerGatewayService implements ICustomerGatewayService{

    public WebClient webClient = WebClient.create();

    @Override
    public Flux<Customer> findAllCustomer() {
        return webClient.get()
                .uri("http://localhost:8080/customer")
                .retrieve()
                .bodyToFlux(Customer.class);
    }
}
