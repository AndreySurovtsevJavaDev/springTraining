package ru.surovcev.project.springboot.service.demo.products.service.services;

import org.springframework.stereotype.Service;
import ru.surovcev.project.springboot.service.demo.products.service.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализовываем 2 сценария по работе с продуктами: добавление новых и выдача всех
 */
@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> findAll() {
        return products;
    }
}
