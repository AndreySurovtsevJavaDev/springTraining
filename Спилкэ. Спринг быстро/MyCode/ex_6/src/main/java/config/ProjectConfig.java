package config;

import main.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "main")
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
    // Можем определить один из бимов как первичный, тогда при запросе бима из метода main, если мы не укажем
    // конкретный, то получим дефолтный
    @Primary
    Parrot parrot2(){
        var p = new Parrot();
        p.setName("Miki");
        return p;
    }

    @Bean
    Parrot parrot3(){
        var p = new Parrot();
        p.setName("Riki");
        return p;
    }

    @Bean
    String hello() {return "Hello";}

    @Bean
    Integer ten() {return 10;}

}
