package ru.surovcev.project.springboot.service.demofeignclient.controller;

import ru.surovcev.project.springboot.service.demofeignclient.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.surovcev.project.springboot.service.demofeignclient.proxy.PaymentProxy;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {

    private final PaymentProxy paymentProxy;

    public PaymentController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        return paymentProxy.createPayment(requestId, payment);
    }

//    /**
//     * Добавляем логгеры, чтобы убедиться, что соответствующие методы получают нужные данные
//     * Напоминалка: Logger != AOP. Это обычное логирование: мы явно вызываем методы logger в коде
//     * AOP-логирование: Логирование добавляется автоматически через "аспекты" без модификации основного кода
//     */
//    private static Logger logger =
//            Logger.getLogger(PaymentController.class.getName());
//
//    @PostMapping("/payment")
//    public ResponseEntity<Payment> createPayment(
//            @RequestHeader String requestId,
//            @RequestBody Payment payment) {
//
//        logger.info("Полученный запрос, id: " + requestId + " сумма платежа: " + payment.getAmount());
//        /**
//         * передаём методу id из хедера
//         */
//        payment.setPaymentId(requestId);
//        /**
//         * Почему id я присваиваю явно, а для amount этого не требуется:
//         * Когда Spring получает HTTP-запрос с телом (@RequestBody), он автоматически преобразует
//         * JSON в объект Java с помощью библиотеки (например, Jackson).
//         * Если JSON содержит поле amount, оно будет присвоено автоматически
//         */
//
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .header("requestId", requestId)
//                .body(payment);
//    }
}
