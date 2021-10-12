package com.example.demo.service.customer;

import com.example.demo.model.Customer;
import com.example.demo.service.GeneralService;
import reactor.core.publisher.Flux;

public interface ICustomerService extends GeneralService<Customer> {
    Flux<Customer> findCustomerByRequirementsExists(boolean exists);

    Flux<Customer> findByRequirementsPrice(double price);

    Flux<Customer> findCustomerByAgentIdExists(boolean exists);

    Flux<Customer> findByAgentId(Long agentId);

}
