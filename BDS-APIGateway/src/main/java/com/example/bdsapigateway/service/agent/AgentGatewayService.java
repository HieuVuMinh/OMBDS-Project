package com.example.bdsapigateway.service.agent;

import com.example.bdsapigateway.modelDTO.Agent;
import com.example.bdsapigateway.modelDTO.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AgentGatewayService implements IAgentGatewayService {

    public WebClient webClient = WebClient.create();

    @Autowired
    Environment env;

    @Override
    public Flux<Agent> findAllAgent() {
        return webClient.get()
                .uri(env.getProperty("BASE_URL_AGENT")+"/agents")
                .retrieve()
                .bodyToFlux(Agent.class);
    }

    @Override
    public Mono<Agent> findByAgentId(Long id) {
        return webClient.get()
                .uri(env.getProperty("BASE_URL_AGENT")+"/agents/" + id)
                .retrieve()
                .bodyToMono(Agent.class);
    }


}
