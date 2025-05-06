package ru.surovcev.project.demospringdatajdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.surovcev.project.demospringdatajdbc.dto.TransferRequest;
import ru.surovcev.project.demospringdatajdbc.model.Account;
import ru.surovcev.project.demospringdatajdbc.service.TransferService;

import java.util.List;

@RestController
public class TransferController {
    /**
     * Внедряем зависимость (DI)
     */
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    /**
     *
     * Здесь TransferRequest мы вынесли в ДТО
     * В предыдущих примерах делали без ДТО, через requestParam
     * @param request
     */
    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request){
        transferService.transferMoney(
             request.getSenderAccountId(),
             request.getReceiverAccountId(),
             request.getAmount());
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(@RequestParam(required = false) String name){
        if (name == null) {
            return transferService.getAllAccounts();
        } else {
            return transferService.findAccountsByName(name);
        }
    }
}
