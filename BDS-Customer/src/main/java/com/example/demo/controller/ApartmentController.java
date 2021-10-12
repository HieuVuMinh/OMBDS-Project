package com.example.demo.controller;


import com.example.demo.model.Apartment;
import com.example.demo.service.apartment.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("apartment")
@AllArgsConstructor
@RestController
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping
    public Flux<Apartment> getAll(){
        return apartmentService.getAll();
    }

    @GetMapping("{id}")
    public Mono<Apartment> getById(@PathVariable("id") String id) {
        return apartmentService.getById(id);
    }

    @PostMapping
    public Mono save(@RequestBody Apartment apartment){
        return apartmentService.save(apartment);
    }

    @PutMapping("{id}")
    public Mono updateById(@PathVariable("id") String id, @RequestBody Apartment apartment){
        Mono<Apartment> apartmentMono = apartmentService.getById(id);
        if (apartmentMono == null){
            System.out.println("Apartment not found");
        }
        return apartmentService.save(apartment);
    }

    @DeleteMapping("{id}")
    public Mono delete(@PathVariable("id") String id){
        return apartmentService.delete(id);
    }
}
