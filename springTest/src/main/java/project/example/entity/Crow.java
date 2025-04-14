package project.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

// ex.6 Стереотипные аннотации.
// Помечаем класс аннотацией @Componenent - сообщаем Spring, что данный класс является компонентом
//  - Автоматически обнаруживаются Spring'ом через сканирование пакетов (component scanning).
//  - Используются для собственных классов, которые должны быть управляемыми Spring'ом.
//  - Упрощают декларативное создание бинов.

// Минусы:
//  - таким образом мы добавляем в контекст только 1 экземпляр класса.
//  - не получится загрузить бин примитива, как делали с ten(Integer) и month(String)
//  -
@Component
public class Crow {
    private String name = "Учёный";
    // т.е в мы не пишем никакой логики в файле конфигурации, а реализуем её тут же.

    // @PostConstruct и @PreDestroy
    // Для использования нужно подтянуть зависимость, т.к после 8й джавы вычистили все АПИ не имеющие отношения к SE
    // <!-- https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api -->
    //<dependency>
    //    <groupId>javax.annotation</groupId>
    //    <artifactId>javax.annotation-api</artifactId>
    //    <version>1.3.2</version>
    //</dependency>
    // @PreDestroy рекомендуется вообще не использовать. стр 75

    @PostConstruct          // позволяет выполнить несколько инструкций после создания бина (ex.7)
    public void init() {
        this.name = "Мудрый";
    }

    public String getName() {
        return name;
    }

    // ex.8 Добавление бина в контекст с помощью registerBean
    // хотим добавлять в контекст только белых ворон
    // добавляем булевый атрибут для простоты
    private boolean isWhite;
    // добавляем конструктор, чтобы создать список ворон
    public Crow(String name, boolean isWhite) {
        this.name = name;
        this.isWhite = isWhite;
    }
    // возвращаем конструктор по умолчанию. чтобы использовать в supplier (для метода registerBean)
    public Crow(){}

    public boolean isWhite() {
        return isWhite;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", isWhite=" + isWhite + "]";
    }

    // ch.3 ex 3 @Autowired. Внедрение значений через поля класса.
    // для этого примера Нам снова тербуется класс, помеченный аннотацией @Component, нового тут писать уже ничего не надо.

}
