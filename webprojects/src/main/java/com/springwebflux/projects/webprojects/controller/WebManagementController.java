package com.springwebflux.projects.webprojects.controller;

import com.springwebflux.projects.webprojects.entities.WebManagement;
import com.springwebflux.projects.webprojects.service.WebManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webmanagement")
@Slf4j
@RequiredArgsConstructor
public class WebManagementController {

    private final WebManagementService webManagementService;


    @GetMapping("/managements")
    public Flux<WebManagement> webManagements() {
        return this.webManagementService.webManagements();
    }


    @GetMapping("/managements/by/{id}")
    public Mono<WebManagement> webManagementBy(@PathVariable String id) {
        return this.webManagementService.webManagements(id);
    }

    @PostMapping("/create/webmanagement")
    public Mono<WebManagement> createWebManagement(@RequestBody WebManagement webManagement) {
        return this.webManagementService.create(webManagement);
    }

    @DeleteMapping("/delete/webmanagement/by/{id}")
    public Mono<Void> deleteWebManagement(@PathVariable String id) {
        return this.webManagementService.deleteById(id);
    }
}
