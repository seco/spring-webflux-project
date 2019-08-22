package com.springwebflux.projects.webprojects.entities;

import com.springwebflux.projects.webprojects.annotation.TestAnnotation;
import com.springwebflux.projects.webprojects.annotation.TestAnnotation2;
import org.springframework.stereotype.Component;

@TestAnnotation
@TestAnnotation2
@Component
public class MultipleSameInstanceImpl3 implements MultipleSameInstance {
    @Override
    public String value() {
        return "testInterfaceImpl3";
    }
}
