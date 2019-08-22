package com.springwebflux.projects.beans.wiringbeans;

import com.springwebflux.projects.annotation.Gorilla;
import com.springwebflux.projects.beans.wiringbeans.Animal;
import org.springframework.stereotype.Component;

@Gorilla
@Component
public class GorillaImpl implements Animal {
    @Override
    public String defineYourself() {
        return "Gorilla";
    }
}
