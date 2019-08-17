package com.springwebflux.projects.webprojects.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@ComponentScan(basePackages = {"com.springwebflux.projects.webprojects"})
@EnableWebFlux
@EnableReactiveMongoRepositories(basePackages = {"com.springwebflux.projects.webprojects"})
public class WebProjectsConfiguration {
}
