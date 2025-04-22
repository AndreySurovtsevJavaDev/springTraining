package ru.surovcev.project.springboot.service.demo.products.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoProductsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProductsServiceApplication.class, args);
    }

}
/**
 * Примечание: данное приложение имеет очень упрощённую структуру, для демонстрации работы с HTTP-методами
 * В реальном приложении изменение списка определённого как атрибут бина приведёт к состоянию гонки (т.к изменения будут вносить n-пользователей)
 * Не следует использовать подобный подход в реальных приложениях
 */
