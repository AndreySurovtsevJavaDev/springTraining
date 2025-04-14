package project.example.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import project.example.entity.Parrot;
import project.example.entity.Person;


// Файл конфигурации. Бывают и в виде xml, но на текущих боевых проектах у нас классы. (Для xml в main путь указывается иначе)
// Здесь мы добавляем экземпляры объектов, которые должны стать бином, т.е всеми добавленными экземплярами Spring будет управлять.
@Configuration
@ComponentScan(basePackages = "project.example.entity") // ex.6 Стереотипные аннотации. Сообщаем спрингу, где находятся классы помеченные как @Component
public class ProjectConfig {

    // @Bean сообщит Spring о том, что при инициализации контекста нужно вызвать данный метод и
    //добавить возвращённое им значение в контекст
    //  - Используется в классах, помеченных как @Configuration.
    //  - Позволяет явно определять бины вручную.
    //  - Подходит для настройки сторонних библиотек или объектов, которые не управляются Spring'ом напрямую.
    @Bean
    public Parrot parrot() {                   // Несмотря на то что это метод и обычно они имеют в наименовании глагол, в спринге принято иначе. См файл theory
        // ex1 создаём экземпляр объекта и помещаем в контекст Spring
        var parrot = new Parrot();
        parrot.setName("Koko");         // Тут мы указали имя сами, в реале получим его из АПИ.
        return parrot;                  // Spring добавляет в контекст экземпляр класса Parrot, возвращаемый методом.
    }

    // ex.2 Добавляем экземпляры других объектов.
    // В данном случае, для примитивов мы не создавали новые классы, а использовали классы-обёртками. т.к они уже есть из коробки.
    @Bean
    Integer ten() {
        return 10;
    }

    @Bean
    String month(){
        return "January";
    }

    // ex.3-4 добавление в контекст множества экземпляров одного типа.
    // Мы никак не ограничены количеством экземпляров одного типа, но при этом на них придётся ссылаться по конкретным именам
    // Чтобы этим не заниматься, можно сделать один из бинов первичным, с помощью аннотации @Primary

    @Bean
    @Primary
    // Теперь по умолчанию (если не ссылаться по конкретному имени) когда будем ссылаться на экземпляр Parrot, то будем получать именно этот.
    public Parrot parrot1() {
        var parrot = new Parrot();
        parrot.setName("Miki");
        return parrot;
    }

    // ex.6 Стереотипные аннотации
    // В данном случае мы использовали @ComponentScan(basePackages = "путь до папки") и нам больше не нужно использовать дополнительные методы

    //------------------------------------------------------------------------------------------------------------------

    // ch.3 ex.1 установка связей между бинами
    // добавляем экземпляры класса Person в контекст с помощью @Bean
    @Bean
    public Person person() {
        var person = new Person();
        person.setName("Гендальф");
       //  Устанавливаем связь между бинами (типа has-A) путём прямого вызова одного метода с аннотацией @Bean из другого такого же метода.
        person.setParrot(parrot());
        return person;
    }

    // ch.3 ex.2 Монтаж бинов путём передачи параметра в метод с аннотацией @Bean
    @Bean
//    @Primary        //  помечаю как предпочтительный, чтобы Спринг понимал из чего выбирать. т.к уже есть несколько бинов от одного класса, но если в main везде ссылаться по конкретному имени, то можно и не помечать.
    public Person person1(Parrot parrot1) {
        var person = new Person();
        person.setName("Фродо");
        person.setParrot(parrot1);
        return person;
    }

    // ch.3 ex 4. Выбор из нескольких бинов
    // здесь мы обращаемся напрямую по именам: public Person person2(Parrot parrot2){}
    @Bean
    public Parrot parrot2() {
        var parrot = new Parrot();
        parrot.setName("Gargulia");
        return parrot;
    }

    // здесь с помощью @Qualifier мы явно указываем Spring на какой конкретный бин из множества смотреть.
    @Bean
    public Person person2(@Qualifier("parrot2")Parrot parrot2) {
        var person = new Person();
        person.setName("Леголас");
        person.setParrot(parrot2);
        return person;
    }

    @Bean
    public Person person3(Parrot parrot2) {
        var person = new Person();
        person.setName("Гимли");
        person.setParrot(parrot2);
        return person;
    }
}
