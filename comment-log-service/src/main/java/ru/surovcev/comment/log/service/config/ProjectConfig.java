package ru.surovcev.comment.log.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = "ru.surovcev.comment.log.service.service")
public class ProjectConfig {

}
