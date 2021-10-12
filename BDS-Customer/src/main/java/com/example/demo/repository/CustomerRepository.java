package com.example.demo.repository;

import com.example.demo.model.Customer;
import com.example.demo.model.Requirement;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

//    @Query(value = "{ 'customer.requirements' : { '$exists' : 'true' }, 'customer.agent_id' : { '$exists' : 'true' }}")
    Flux<Customer> findCustomerByRequirementsExists(boolean exists);

    Flux<Customer> findCustomerByAgentIdExists(boolean exists);

    Flux<Customer> findByRequirementsPrice(double price);

    Flux<Customer> findByAgentId(Long agentId);
}