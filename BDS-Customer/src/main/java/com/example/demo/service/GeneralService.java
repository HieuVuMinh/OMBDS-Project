package com.example.demo.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GeneralService<T> {
    Flux<T> getAll();

    Mono<T> getById(String id);

    Mono save(T t);

    Mono delete(String id);
}
