package config;

import main.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    // Добавив аннотацию @Bean, мы сообщаем Spring, что при инициализации нужно будет вызвать именно этот метод
    // и добавить в контекст возвращаемое значение.
    @Bean
    Parrot parrot1(){
        var p = new Parrot();
        // назначаем имя, которое будем использовать при тестировании
        p.setName("Koko");
        // Spring добавляет в контекст экземпляр класса Parrot возвращаемый методом.
       return p;
    }

    @Bean
    String hello() {return "Hello";}

    @Bean
    Integer ten() {return 10;}

}
