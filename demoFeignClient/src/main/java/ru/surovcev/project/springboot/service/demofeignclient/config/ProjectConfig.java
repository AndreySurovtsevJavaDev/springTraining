package ru.surovcev.project.springboot.service.demofeignclient.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * Активируем клиентов OpenFeign и сообщаем зависимости OpenFeign где следует искать прокси-контракты
 */
@Configuration
@EnableFeignClients(
        basePackages = "ru.surovcev.project.springboot.service.demofeignclient.proxy"
)
public class ProjectConfig {

}
