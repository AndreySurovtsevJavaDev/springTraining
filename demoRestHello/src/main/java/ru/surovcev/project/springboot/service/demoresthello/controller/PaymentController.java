package ru.surovcev.project.springboot.service.demoresthello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.surovcev.project.springboot.service.demoresthello.exception.NotEnoughMoneyException;
import ru.surovcev.project.springboot.service.demoresthello.model.ErrorDetails;
import ru.surovcev.project.springboot.service.demoresthello.model.PaymentDetails;
import ru.surovcev.project.springboot.service.demoresthello.service.PaymentService;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try{
            PaymentDetails paymentDetails = paymentService.processPayment();

            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        } catch (NotEnoughMoneyException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money to make payment");
            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
        }
    }
}
