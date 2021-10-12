package com.example.demo.repository;

import com.example.demo.model.Apartment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ApartmentRepository extends ReactiveMongoRepository<Apartment, String> {
}
