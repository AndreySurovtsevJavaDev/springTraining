package project.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.example.entity.Crow;
import project.example.entity.Person;
import project.example.entity.Parrot;
import project.example.config.ProjectConfig;
import project.example.entity.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class Main {
    public static void main(String[] args) {
        // строчка делает так, чтобы Spring использовал указанный класс конфигурации при инициализации контекста
        // т.е создаёт экземпляр контекста Spring
        // для этого используем класс AnnotstionConfigApplicationContex
        var context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        System.out.println("------------Глава 2: добавление бинов в контекст Spring------------");

        // получаем ссылку на бин типа Parrot
        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());

        // ex.3-4 получаем конкретный бин из нескольких (одного типа)
        // так как один из них обозначен как @Primary
        Parrot parrot1 = context.getBean("parrot", Parrot.class);
        System.out.println(parrot1.getName());

        // ex.2 Получаем ссылку на другие бины типа ten и month
        // практическое применение пока не ясно, но для понимаю возможного разнообразия - пусть будет
        Integer ten = context.getBean(Integer.class);
        System.out.println(ten);

        String month = context.getBean(String.class);
        System.out.println(month);

        // ex.6 Стереотипные аннотации
        Crow crow = context.getBean(Crow.class);
        System.out.println(crow.getName());

        // ex.8 Добавление бина в контекст с помощью registerBean
        // Можно использовать с версии Spring 5
        // создаём список ворон из которого будем помещать белых в контекст
        List<Crow> crows = new ArrayList<>();
        crows.add(new Crow("чёрный", false));
        crows.add(new Crow("тёмный", false));
        crows.add(new Crow("серый", false));
        crows.add(new Crow("чёрно-белый", true));
        crows.add(new Crow("белый", true));

        // Определяем supplier (для метода registerBean)
        Supplier<Crow> crowSupplier = () -> null;       // Поставщик будет переопределен для каждого объекта

        // Далее, циклом пробегаю по списку и добавляю в контекст только isWhite: true
        for (Crow c : crows) {
            if (c.isWhite()) {
                // Создаем уникальное имя для бина
                String beanName = "whiteCrow_" + c.getName();
                // Регистрируем бин с уникальным именем
                context.registerBean(beanName, Crow.class, crowSupplier);               // а можно вместо crowSupplier подставить лямбду сюда: () -> c (получим сразу ворона из списка)
                System.out.println("Белый ворон включен в контекст: " + c.getName());
            }
        }

        //-----------------------------------------------------------------------------------------------------------------------------------
        System.out.println("------------Глава 3: установка связей между бинами------------");

        // ch.3 ex1-3 установка связей между Бинами
        // 1. путём прямого вызова одного метода с аннотацией @Bean из другого такого же метода.
        Person person = context.getBean("person",Person.class);
        System.out.println("Person's name: " + person.getName() + " \n" + "Person's parrot: " + person.getParrot());

        // ch.3 ex1-3 установка связей между Бинами
        // 2. Путём передачи параметра в метод с аннотацией @Bean
        Person person1 = context.getBean("person1", Person.class);             // здесь я могу не передовать имя,  тк использую @Primary и подставится значение по умолчанию (сейчас Primary отключен, для изучения разных способов DI)
        System.out.println("Person's name: " + person1.getName() + " \n" + "Person's parrot: " + person1.getParrot());

        // 3 с использованием аннотации @Autowired (тут всю магию нужно смотреть в классах Wizard и Crow, в конфиге только путь)
        Wizard wizard = context.getBean(Wizard.class);
        System.out.println(wizard);

        // 4. Выбор из нескольких бинов в контексте
        // с использованием аннотации @Qualifier. см. файл конфигурации
        Person person3 = context.getBean("person3", Person.class);
        System.out.println("Person's name: " + person3.getName() + " \n" + "Person's parrot: " + person3.getParrot());

        // По имени бина. Здесь, в файле конфиурации мы передаём конкретных попугов бинам аргументом(параметром)
        // Сейчасв в выдаче будет бин помеченный как Primary, т.к у меня не получается заставить работать этот метод. может обновить надо чего.
        Person person2 = context.getBean("person2", Person.class);
        System.out.println("Person's name: " + person2.getName() + " \n" + "Person's parrot: " + person2.getParrot());

        //-----------------------------------------------------------------------------------------------------------------------------------
        System.out.println("------------Глава 4: Использование абстракций------------");
        // В новом проекте

        //------------------------------------------------------------------------------------------------------------------------------------
        // После того как поработали с контекстом его нужно обязательно закрывать. Х.з где это такое написано, и как оно на реальных проектах
        context.close();
    }
}
