package com.example.bdsapigateway.service.agent;

import com.example.bdsapigateway.modelDTO.Agent;
import com.example.bdsapigateway.modelDTO.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AgentGatewayService implements IAgentGatewayService {

    public WebClient webClient = WebClient.create();

    @Override
    public Flux<Agent> findAllAgent() {
        return webClient.get()
                .uri("http://localhost:8082/agents")
                .retrieve()
                .bodyToFlux(Agent.class);
    }

    @Override
    public Mono<Agent> findByAgentId(Long id) {
        return webClient.get()
                .uri("http://localhost:8082/agents/id/" + id)
                .retrieve()
                .bodyToMono(Agent.class);
    }


}
