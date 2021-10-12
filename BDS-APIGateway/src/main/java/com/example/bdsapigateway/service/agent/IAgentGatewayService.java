package com.example.bdsapigateway.service.agent;

import com.example.bdsapigateway.modelDTO.Agent;
import com.example.bdsapigateway.modelDTO.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAgentGatewayService {
    Flux<Agent> findAllAgent();

    Mono<Agent> findByAgentId(Long id);

}