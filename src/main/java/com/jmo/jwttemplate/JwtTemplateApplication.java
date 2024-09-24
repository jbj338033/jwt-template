package com.jmo.jwttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class JwtTemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtTemplateApplication.class, args);
    }
}
