package com.springreact.projects.webprojects.service;

import com.springreact.projects.webprojects.entities.WebManagement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WebManagementService {
    Flux<WebManagement> webManagements();

    Mono<WebManagement> webManagements(String id);

    Mono<WebManagement> create(WebManagement webManagement);

    Mono<WebManagement> create(Mono<WebManagement> webManagement);

    Mono<Void> deleteById(String id);
}
