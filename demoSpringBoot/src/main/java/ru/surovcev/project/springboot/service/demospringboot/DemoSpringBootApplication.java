package ru.surovcev.project.springboot.service.demospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Аннотация @SpringBootApplication объявляет, что данный класс является главным классом приложения Spring Boot
 */
@SpringBootApplication
public class DemoSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootApplication.class, args);
    }

}
