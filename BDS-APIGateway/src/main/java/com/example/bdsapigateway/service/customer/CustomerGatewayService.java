package com.example.bdsapigateway.service.customer;

import com.example.bdsapigateway.modelDTO.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerGatewayService implements ICustomerGatewayService{

    public WebClient webClient = WebClient.create();

    @Override
    public Flux<Customer> findAllCustomer() {
        return webClient.get()
                .uri("http://localhost:8080/customers")
                .retrieve()
                .bodyToFlux(Customer.class);
    }

    @Override
    public Flux<Customer> findCustomerByAgentId(Long id) {
        return webClient.get()
                .uri("http://localhost:8080/customers/agent/" + id)
                .retrieve()
                .bodyToFlux(Customer.class);
    }

    @Override
    public Flux<Customer> findCustomerHaveNoAssistance() {
        return webClient.get()
                .uri("http://localhost:8080/customers/agent")
                .retrieve()
                .bodyToFlux(Customer.class);
    }

    @Override
    public Mono<Customer> updateCustomerAssistanceByAgent(String id, Customer customer) {
        return webClient.put()
                .uri("http://localhost:8080/customers/" + id)
                .body(Mono.just(customer), Customer.class)
                .retrieve()
                .bodyToMono(Customer.class);
    }

    @Override
    public Mono<Customer> findCustomerById(String id) {
        return webClient.get()
                .uri("http://localhost:8080/customers/" + id)
                .retrieve()
                .bodyToMono(Customer.class);
    }


}
