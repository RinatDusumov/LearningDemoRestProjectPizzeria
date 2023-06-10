package com.learningrestprojectpizzeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@PropertySource(value = "classpath:variables.properties")
public class LearningRestProjectPizzeriaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LearningRestProjectPizzeriaApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LearningRestProjectPizzeriaApplication.class);
    }
}