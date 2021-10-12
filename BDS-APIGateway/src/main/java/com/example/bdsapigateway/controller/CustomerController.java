package com.example.bdsapigateway.controller;

import com.example.bdsapigateway.modelDTO.Customer;
import com.example.bdsapigateway.service.CustomerGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api-gateway")
public class CustomerController {

    @Autowired
    private CustomerGatewayService customerGatewayService;

    @GetMapping
    private Flux<Customer> findAllCustomer(){
        return customerGatewayService.findAllCustomer();
    }
}
