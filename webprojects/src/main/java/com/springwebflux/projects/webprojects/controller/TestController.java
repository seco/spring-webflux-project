package com.springwebflux.projects.webprojects.controller;

import com.springwebflux.projects.webprojects.annotation.TestAnnotation;
import com.springwebflux.projects.webprojects.annotation.TestAnnotation2;
import com.springwebflux.projects.webprojects.entities.MultipleSameInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testcontroller")
public class TestController {

    @Autowired
    @TestAnnotation
    @TestAnnotation2
    private MultipleSameInstance testInterface;

    @GetMapping("/v1")
    public String getTestInstance() {
        return this.testInterface.value();
    }
}
