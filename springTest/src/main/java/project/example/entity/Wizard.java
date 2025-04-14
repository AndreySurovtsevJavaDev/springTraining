package project.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Wizard {
    private String name = "Гермиона";

    // ch.3 ex 1-3. Внедрение значение через поле
    // как устанавливается связь - мы даём спрингу команду извлечь бин из контекста и присвоить его в качестве значения поля с аннотацией @Autowired
//    @Autowired
//    private Crow crow;

    // Внедрение значения через конструктор
    // Реализацию через поле пришлось закоментить, т.к они конфликтуют.
    private final Crow crow;

    @Autowired
    public Wizard(Crow crow) {this.crow = crow;}

    @Override
    public String toString() {return "Wizard [name=" + name + ", crow=" + crow + "]";}
}
