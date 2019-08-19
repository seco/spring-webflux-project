package com.springwebflux.projects.webprojects.configuration;

import com.springwebflux.projects.webprojects.entities.WebManagement;
import com.springwebflux.projects.webprojects.service.WebManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@EnableWebFlux
public class WebManagementConfiguration {

    @Autowired
    private WebManagementService webManagementService;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return route(GET("/routerFunction/test"),serverRequest -> ok().body(webManagementService.webManagements(), WebManagement.class));
    }
}
