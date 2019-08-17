package com.springwebflux.projects.webprojects.repo;

import com.springwebflux.projects.webprojects.entities.WebManagement;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface WebManagementRepository extends ReactiveCrudRepository<WebManagement, String> {
}
