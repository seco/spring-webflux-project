package com.springreact.projects.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = {"com.springreact.projects.beans.wiringbeans"})
public class WiringBeanConfigurations {
}
