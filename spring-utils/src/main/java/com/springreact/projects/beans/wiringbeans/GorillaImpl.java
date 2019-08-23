package com.springreact.projects.beans.wiringbeans;

import com.springreact.projects.annotation.Gorilla;
import org.springframework.stereotype.Component;

@Gorilla
@Component
public class GorillaImpl implements Animal {
    @Override
    public String defineYourself() {
        return "Gorilla";
    }
}
