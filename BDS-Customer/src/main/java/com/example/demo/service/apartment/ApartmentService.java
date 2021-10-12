package com.example.demo.service.apartment;

import com.example.demo.model.Apartment;
import com.example.demo.repository.ApartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class ApartmentService implements IApartmentService{

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Override
    public Flux<Apartment> getAll() {
        return apartmentRepository.findAll();
    }

    @Override
    public Mono<Apartment> getById(String id) {
        return apartmentRepository.findById(id);
    }

    @Override
    public Mono save(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    @Override
    public Mono delete(String id) {
        return apartmentRepository.deleteById(id);
    }
}
