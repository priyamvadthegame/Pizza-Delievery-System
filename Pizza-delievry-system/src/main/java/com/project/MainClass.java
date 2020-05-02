package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.project")
public class MainClass
{
    public static void main( String[] args )
    {
        SpringApplication.run(MainClass.class, args);
    }
}