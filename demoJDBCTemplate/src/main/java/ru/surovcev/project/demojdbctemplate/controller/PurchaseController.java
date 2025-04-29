package ru.surovcev.project.demojdbctemplate.controller;

import org.springframework.web.bind.annotation.*;
import ru.surovcev.project.demojdbctemplate.model.Purchase;
import ru.surovcev.project.demojdbctemplate.repository.PurchaseRepository;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    /**
     * Используя внедрение зависимости в конструктор, извлекаем объект репозитория из контекста Spring
     * @param purchaseRepository
     */
    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    /**
     * Создаём эндпоинт, который клиент может вызвать, чтобы сохранить данные в БД
     * Для сохранения данных используем метод репозитория storePurchase()
     * @param purchase
     */
    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.storePurchase(purchase);
    }

    /**
     * Создаём эндпоинт, который вызывает клиент, чтобы получиьт все записи из таблицы в БД
     * Для получения данных используем метод репозитория findAllPurchase
     * @return
     */
    @GetMapping("/get-all")
    public List<Purchase> getAllPurchases() {
       return purchaseRepository.findAllPurchase();
    }
}
