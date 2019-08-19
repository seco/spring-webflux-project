package com.springwebflux.projects.webprojects.service;

import com.springwebflux.projects.webprojects.entities.WebManagement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WebManagementService {
    Flux<WebManagement> webManagements();

    Mono<WebManagement> webManagements(String id);

    Mono<WebManagement> create(WebManagement webManagement);

    Mono<WebManagement> create(Mono<WebManagement> webManagement);

    Mono<Void> deleteById(String id);
}
