package ru.surovcev.project.demoresttemplate.proxy;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.surovcev.project.demoresttemplate.model.Payment;
import org.springframework.http.HttpHeaders;

import java.util.UUID;

/**
 * Прокси (PaymentProxy) отвечает за:
 * - Взаимодействие с внешним API/сервисом (обращение к внешнему сервису)
 * - Сериализацию/десериализацию данных
 * - Обработку ошибок сети
 */

/**
 * @Component — говорит Spring'у создать бин PaymentProxy и управлять им (внедрять, где нужно).
 */
@Component
public class PaymentProxy {

    /**
     * restTemplate - клиент для HTTP-запросов. Через него будут отправляться REST-запросы
     */
    private final RestTemplate restTemplate;

    /**
     * Аннотация @Value("${name.service.url}") говорит: вставить значение из application.properties
     * по ключу name.service.url (http://localhost:8080).
     * это у нас будет базовый адрес
     */
    @Value("${name.service.url}") // URL из application.properties
    private String paymentServiceUrl;

    /**
     * Конструктор: получает RestTemplate как параметр и сохраняет в поле.
     * Это и есть внедрение зависимости через конструктор (Dependency Injection).
     * @param restTemplate
     */
    public PaymentProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Метод createPayment: принимает объект Payment и создаёт его через REST API.
     * @param payment
     * @return
     */
    public Payment createPayment(Payment payment) {
        /**
         * Собираем полный URL запроса: базовый адрес + путь /payments.
         */
        String uri = paymentServiceUrl + "/payments";

        /**
         * Создаём объект для HTTP-заголовков запроса
         */
        HttpHeaders headers = new HttpHeaders();
        headers.set("requestId", UUID.randomUUID().toString());

        /**
         * Упаковываем объект payment и заголовки в один объект HttpEntity.
         */
        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);

        /**
         * Это будет содержимое HTTP-запроса.
         * Отправляем HTTP-запрос методом POST:
         * на адрес uri,
         * с телом httpEntity,
         * ожидаем, что в ответ придёт объект типа Payment.
         */
        ResponseEntity<Payment> response = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                httpEntity,
                Payment.class
        );

        /**
         * Возвращаем тело ответа (Payment), полученное от сервера.
         */
        return response.getBody();
    }
}
