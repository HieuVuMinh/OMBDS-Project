package com.example.bdsapigateway.controller;

import com.example.bdsapigateway.modelDTO.Agent;
import com.example.bdsapigateway.modelDTO.Customer;
import com.example.bdsapigateway.service.agent.AgentGatewayService;
import com.example.bdsapigateway.service.customer.CustomerGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

    @Autowired
    private CustomerGatewayService customerGatewayService;

    @Autowired
    private AgentGatewayService agentGatewayService;

    @GetMapping("/customers")
    private Flux<Customer> findAllCustomer(){
        return customerGatewayService.findAllCustomer();
    }

    @GetMapping("/customers/agent-id/{id}")
    public Flux<Customer> findCustomerByAgentId(@PathVariable("name") Long id){
        Agent monoAgent = agentGatewayService.findByAgentId(id).block();

        if(monoAgent != null){
            System.out.println(monoAgent.getId());
            return customerGatewayService.findCustomerByAgentId(monoAgent.getId());
        }
        return null;
    }

    @GetMapping("/customers/agent-exist")
    public Flux<Customer> findCustomerHaveNoAssistance(){
        return customerGatewayService.findCustomerHaveNoAssistance();
    }

    @GetMapping("/customer/{id}")
    public Mono<Customer> findCustomerById(String id){
        return customerGatewayService.findCustomerById(id);
    }

    @GetMapping("customer/{idCustomer}/assistance/{idAgent}")
    public Mono<Customer> updateCustomerAssistanceByAgent(@PathVariable("idCustomer") String idCustomer,
                                                          @PathVariable("idAgent") Long idAgent){
        Customer customerMono = findCustomerById(idCustomer).block();
        customerMono.setAgentId(idAgent);

        return customerGatewayService.updateCustomerAssistanceByAgent(idCustomer, customerMono);
    }

    @PostMapping("/customer")
    public Mono<Customer> createCustomer(@RequestBody Customer customer){
        return customerGatewayService.createCustomer(customer);
    }
}
