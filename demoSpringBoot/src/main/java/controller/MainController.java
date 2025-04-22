package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("home")       // С помощью аннотации @RequestMapping() привязываем действие к пути http-запроса
    public String home(Model page) {
        page.addAttribute("username", "Katy");
        page.addAttribute("color", "red");
        return "home.html";     // возвращаем имя html-документа, в котором содержится то, что браузер должен вывести на экран
    }
}
