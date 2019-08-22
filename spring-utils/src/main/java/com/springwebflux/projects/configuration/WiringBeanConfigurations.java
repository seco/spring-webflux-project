package com.springwebflux.projects.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = {"com.springwebflux.projects.beans.wiringbeans"})
public class WiringBeanConfigurations {
}
