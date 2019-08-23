package com.springreact.projects;

import com.springreact.projects.annotation.Gorilla;
import com.springreact.projects.annotation.Monkey;
import com.springreact.projects.beans.wiringbeans.Animal;
import com.springreact.projects.configuration.WiringBeanConfigurations;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WiringBeanConfigurations.class)
@Slf4j
public class WiringBeansTest {

    @Autowired
    @Gorilla
    private Animal gorilla;

    @Autowired
    @Monkey
    private Animal monkey;

    @Test
    public void testBeansCorrectlyWired() {
        log.info("Wired Bean 1 :" + this.gorilla.defineYourself());
        log.info("Wired Bean 2:" + this.monkey.defineYourself());
        Assertions.assertEquals(this.gorilla.defineYourself(), "Gorilla");
        Assertions.assertEquals(this.monkey.defineYourself(), "Monkey");
    }
}