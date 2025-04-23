package ru.surovcev.project.springboot.service.demo.products.service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.surovcev.project.springboot.service.demo.products.service.services.ProductService;

@Controller
public class ProductsController {
    /**
     * Чтобы получить бин сервиса из контекста Spring, мы используем DI в конструкторе контроллера
     */
    private final ProductService productService;
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Передача списка товаров в представление
     */
    @RequestMapping("/products")        // связываем действие контроллера с путём products
    public String viewProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }
}
