package com.example.demo.controller;

import com.example.demo.model.Requirement;
import com.example.demo.service.requirement.RequirementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("requirement")
@AllArgsConstructor
@RestController
public class RequirementController {

    @Autowired
    private RequirementService requirementService;

    @GetMapping
    public Flux<Requirement> getAll(){
        return requirementService.getAll();
    }

    @GetMapping("{id}")
    public Mono<Requirement> getById(@PathVariable("id") String id) {
        return requirementService.getById(id);
    }

    @PostMapping
    public Mono save(@RequestBody Requirement requirement){
        return requirementService.save(requirement);
    }

    @PutMapping("{id}")
    public Mono updateById(@PathVariable("id") String id, @RequestBody Requirement requirement){
        Mono<Requirement> requirementMono = requirementService.getById(id);
        if (requirementMono == null){
            System.out.println("Requirement not found");
        }
        return requirementService.save(requirement);
    }

    @DeleteMapping("{id}")
    public Mono delete(@PathVariable("id") String id){
        return requirementService.delete(id);
    }
}
