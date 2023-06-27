package com.techpro.project.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class DockerSecretsProcessor implements EnvironmentPostProcessor {

    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        System.setProperty("MYSQL_HOST", "192.168.");
        System.setProperty("MYSQL_USERNAME", "root");
        System.setProperty("USERNAME", "root");
    }
}
