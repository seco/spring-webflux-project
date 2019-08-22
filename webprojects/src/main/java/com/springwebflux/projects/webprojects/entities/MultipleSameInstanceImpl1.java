package com.springwebflux.projects.webprojects.entities;

import com.springwebflux.projects.webprojects.annotation.TestAnnotation;
import org.springframework.stereotype.Component;

@TestAnnotation
@Component
public class MultipleSameInstanceImpl1 implements MultipleSameInstance {
    @Override
    public String value() {
        return "testInterfaceImpl1";
    }
}
