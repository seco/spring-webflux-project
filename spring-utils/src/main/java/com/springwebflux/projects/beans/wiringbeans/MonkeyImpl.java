package com.springwebflux.projects.beans.wiringbeans;

import com.springwebflux.projects.annotation.Monkey;
import com.springwebflux.projects.beans.wiringbeans.Animal;
import org.springframework.stereotype.Component;

@Monkey
@Component
public class MonkeyImpl implements Animal {
    @Override
    public String defineYourself() {
        return "Monkey";
    }
}
