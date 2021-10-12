package com.example.demo.service.customer;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Flux<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> getById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Mono save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Mono delete(String id) {
        return customerRepository.deleteById(id);
    }

    @Override
    public Flux<Customer> findCustomerByRequirementsExists(boolean exists) {
        return customerRepository.findCustomerByRequirementsExists(exists);
    }

    @Override
    public Flux<Customer> findByRequirementsPrice(double price) {
        return customerRepository.findByRequirementsPrice(price);
    }

    @Override
    public Flux<Customer> findCustomerByAgentIdExists(boolean exists) {
        return customerRepository.findCustomerByAgentIdExists(exists);
    }

    @Override
    public Flux<Customer> findByAgentId(Long agentId) {
        return customerRepository.findByAgentId(agentId);
    }
}
