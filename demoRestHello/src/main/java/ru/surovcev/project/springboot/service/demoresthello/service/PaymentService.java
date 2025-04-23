package ru.surovcev.project.springboot.service.demoresthello.service;

import org.springframework.stereotype.Service;
import ru.surovcev.project.springboot.service.demoresthello.exception.NotEnoughMoneyException;
import ru.surovcev.project.springboot.service.demoresthello.model.PaymentDetails;

/**
 * Реализуем сценарий использования: выбрасывание исключения, при невозможности выполнить платёж
 */
@Service
public class PaymentService {
    public PaymentDetails processPayment(){
        throw new NotEnoughMoneyException();
    }
}
