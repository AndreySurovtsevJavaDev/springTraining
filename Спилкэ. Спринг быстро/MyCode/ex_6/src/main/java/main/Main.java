package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // создание экземпляра контекста Spring
        // для этого используем класс AnnotationConfigApplicationContex
        var context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // получаем ссылку на бин пита Parrot из контекста Spring
        Parrot p = context.getBean(Parrot.class);

        System.out.println(p.getName());

//        String s = context.getBean(String.class);
//        System.out.println(s);
//
//        Integer n = context.getBean(Integer.class);
//        System.out.println(n);
    }
}
