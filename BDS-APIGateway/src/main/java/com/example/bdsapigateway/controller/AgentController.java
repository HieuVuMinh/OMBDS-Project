package com.example.bdsapigateway.controller;

import com.example.bdsapigateway.modelDTO.Agent;
import com.example.bdsapigateway.service.agent.AgentGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api-gateway")
public class AgentController {

    @Autowired
    private AgentGatewayService agentGatewayService;

    @GetMapping("agents")
    private Flux<Agent> findAllCustomer(){
        return agentGatewayService.findAllAgent();
    }

    @GetMapping("agents/name/{id}")
    public Mono<Agent> findByLastName(@PathVariable("id") Long id) {
        return agentGatewayService.findByAgentId(id);
    }

}
