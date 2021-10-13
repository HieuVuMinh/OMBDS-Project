package com.example.bdsapigateway.controller;

import com.example.bdsapigateway.modelDTO.Agent;
import com.example.bdsapigateway.modelDTO.ResponseObject;
import com.example.bdsapigateway.service.agent.AgentGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<?> findAllCustomer(){
        Flux<Agent> listAgent = agentGatewayService.findAllAgent();
        if(listAgent != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK","Trả dữ liệu thành công!", listAgent.buffer())
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Not Found","Agent không có dữ liệu!", listAgent)
        );
    }

    @GetMapping("agents/name/{id}")
    public ResponseEntity<?> findByLastName(@PathVariable("id") Long id) {
        Agent agent = agentGatewayService.findByAgentId(id).block();
        if(agent != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK","Trả dữ liệu thành công!", agent)
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Not Found","Agent không tồn tại!", agent)
        );
    }


}
