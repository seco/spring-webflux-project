package com.springwebflux.projects.webprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class WebprojectsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebprojectsApplication.class, args);

    }

}
