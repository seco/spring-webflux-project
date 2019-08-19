package com.springwebflux.projects.webprojects.service;

import com.springwebflux.projects.webprojects.entities.WebManagement;
import com.springwebflux.projects.webprojects.repo.WebManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class WebManagementServiceImpl implements WebManagementService {

    private final WebManagementRepository webManagementRepository;

    // TODO : next implementation will contains pagination
    @Override
    public Flux<WebManagement> webManagements() {
        return this.webManagementRepository.findAll();
    }

    @Override
    public Mono<WebManagement> webManagements(String id) {
        return this.webManagementRepository.findById(id);
    }

    @Override
    public Mono<WebManagement> create(WebManagement webManagement) {
        return this.webManagementRepository.save(webManagement);
    }

    @Override
    public Mono<WebManagement> create(Mono<WebManagement> webManagement) {
        return webManagement.flatMap( e-> webManagementRepository.save(e));
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return this.webManagementRepository.deleteById(id);
    }
}
