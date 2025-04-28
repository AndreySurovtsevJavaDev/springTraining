package ru.surovcev.project.demoresttemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *  @Configuration — говорит Spring'у: это класс с настройками (конфигурацией).
 */
@Configuration
public class ProjectConfig {

    /**
     * Метод restTemplate() создаёт бин RestTemplate.
     * Аннотация @Bean регистрирует его в контексте Spring, чтобы потом можно было внедрять (@Autowired или через конструктор).
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}


