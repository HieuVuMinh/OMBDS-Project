package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("customers")
@AllArgsConstructor
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public Flux<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping("{id}")
    public Mono<Customer> getById(@PathVariable("id") String id) {
        return customerService.getById(id);
    }

    @GetMapping("agent/{id}")
    public Flux<Customer> getById(@PathVariable("id") Long id) {
        return customerService.findByAgentId(id);
    }

    @GetMapping("/requirement")
    public Flux<Customer> getAllByRequirement() {
        boolean exist = true;
        return customerService.findCustomerByRequirementsExists(exist);
    }

    @GetMapping("/agent")
    public Flux<Customer> getAllByAgent() {
        boolean exist = false;
        return customerService.findCustomerByAgentIdExists(exist);
    }

    @GetMapping("/price")
    public Flux<Customer> getAllByRequirementPrice(@RequestParam(name = "price") double price) {
        return customerService.findByRequirementsPrice(price);
    }

    @PostMapping
    public Mono save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @PutMapping("{id}")
    public Mono updateById(@PathVariable("id") String id, @RequestBody Customer customer){
        Mono<Customer> customerMono = customerService.getById(id);
        if (customerMono == null){
            System.out.println("Customer not found");
        }
        return customerService.save(customer);
    }

    @DeleteMapping("{id}")
    public Mono delete(@PathVariable("id") String id){
        return customerService.delete(id);
    }
}
