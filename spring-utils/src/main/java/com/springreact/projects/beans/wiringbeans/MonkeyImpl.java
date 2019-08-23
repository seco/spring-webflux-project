package com.springreact.projects.beans.wiringbeans;

import com.springreact.projects.annotation.Monkey;
import org.springframework.stereotype.Component;

@Monkey
@Component
public class MonkeyImpl implements Animal {
    @Override
    public String defineYourself() {
        return "Monkey";
    }
}
