package com.springreact.projects.webprojects.repo;

import com.springreact.projects.webprojects.entities.WebManagement;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebManagementRepository extends ReactiveCrudRepository<WebManagement, String> {
}
