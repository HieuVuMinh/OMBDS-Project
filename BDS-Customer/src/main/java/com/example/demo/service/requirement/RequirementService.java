package com.example.demo.service.requirement;

import com.example.demo.model.Requirement;
import com.example.demo.repository.RequirementRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class RequirementService implements IRequirementService{

    @Autowired
    private RequirementRepository requirementRepository;

    @Override
    public Flux<Requirement> getAll() {
        return requirementRepository.findAll();
    }

    @Override
    public Mono<Requirement> getById(String id) {
        return requirementRepository.findById(id);
    }

    @Override
    public Mono save(Requirement requirement) {
        return requirementRepository.save(requirement);
    }

    @Override
    public Mono delete(String id) {
        return requirementRepository.deleteById(id);
    }
}
