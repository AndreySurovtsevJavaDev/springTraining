package ru.surovcev.comment.log.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.surovcev.comment.log.service.aspects.LoggingAspect;

@Configuration
@ComponentScan(
        basePackages = "ru.surovcev.comment.log.service.service")
@EnableAspectJAutoProxy         // Активирует аспекты в Spring-приложении
public class ProjectConfig {
    /**
     * Добавляем экземпляр класса LoggingAspect в контекст Spring. В этот раз для разнообразия через @Bean, просто чтобы потренить этот метод тоже
     */
    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}
