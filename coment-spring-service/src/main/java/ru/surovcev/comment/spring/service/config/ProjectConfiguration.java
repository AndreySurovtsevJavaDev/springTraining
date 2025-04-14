package ru.surovcev.comment.spring.service.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

/**
 * Класс-конфиг, в котором, для выполнения текущей задачи мы только указываем путь до классов с аннотациями @Component
 */
@Configurable
@ComponentScan(
        basePackages = { "ru.surovcev.comment.spring.service.proxies",
                "ru.surovcev.comment.spring.service.repositoies",
                "ru.surovcev.comment.spring.service.services" })
public class ProjectConfiguration {
}
