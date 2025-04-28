package ru.surovcev.project.demoresttemplate.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.surovcev.project.demoresttemplate.model.Payment;
import ru.surovcev.project.demoresttemplate.proxy.PaymentProxy;

/**
 * Что должен делать контроллер:
 * - Принимать HTTP-запросы
 * - Валидировать входные данные
 * - Возвращать HTTP-ответы
 */

/**
 * Аннотация @RestController — Spring создаст HTTP-контроллер.
 * Методы будут автоматически возвращать JSON.
 */
@RestController
public class PaymentsController {
    /**
     * Внедрение прокси в контроллер через конструктор:
     * - Соблюдает принципы SOLID
     * - Упрощает тестирование
     * - Централизует логику работы с API
     * - Позволяет гибко менять реализацию
     */

    /**
     * paymentProxy — клиент для работы с платежами.
     */
    private final PaymentProxy paymentProxy;

    /**
     * Конструктор с внедрением зависимости PaymentProxy.
     * @param paymentProxy
     */
    public PaymentsController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    /**
     * @PostMapping("/payment") — привязка метода к POST-запросу на /payment.
     * createPayment: принимает объект Payment из тела HTTP-запроса (@RequestBody автоматически превращает JSON в объект).
     * @param payment
     * @return
     */
    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentProxy.createPayment(payment); // Делегирует создание платежа через paymentProxy, а затем возвращает ответ клиенту.
    }
}
