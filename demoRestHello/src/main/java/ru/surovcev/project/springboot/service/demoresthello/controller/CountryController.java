package ru.surovcev.project.springboot.service.demoresthello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.surovcev.project.springboot.service.demoresthello.model.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * обозначаем класс, как REST-контроллер, чтобы Spring добавил бин в контекст и чтобы диспетчер сервлетов не искал
 * представление после окончания работы этого метода
 */
@RestController
public class CountryController {

    @GetMapping("/italy")
    public ResponseEntity<Country> italy() {
        Country country = Country.of("Italy", 61);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "Europe")
                .header("capital", "Rome")
                .header("favorite_food", "Pasta")
                .body(country);
    }


    @GetMapping("/france")      // Связывем действие контроллера с HTTP-методом GET и путём /france
    public Country france() {
        Country country = Country.of("France", 67);
        return country;
    }

    @GetMapping("/all")
    public List<Country> countries() {
        Country country = Country.of("France", 67);
        Country country1 = Country.of("Spain", 47);
        return List.of(country1, country);
    }
}
