package ru.surovcev.project.springboot.service.demoresthello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Класс контроллера содержащий действия для конечной точки REST
 */
@RestController
public class HelloController {
    @GetMapping("/hello")       // с помощью GetMapping связываем HTTP-метод GET и путь с действием контроллера
    public String hello() {return "hello";}

    @GetMapping("/ciao")
    public String ciao() {return "ciao";}
}
