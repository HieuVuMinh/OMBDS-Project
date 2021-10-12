package com.example.demo.repository;

import com.example.demo.model.Requirement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RequirementRepository extends ReactiveMongoRepository<Requirement, String> {
}
