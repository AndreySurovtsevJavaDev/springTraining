package ru.surovcev.project.demotransaction.controller;

import org.springframework.web.bind.annotation.*;
import ru.surovcev.project.demotransaction.model.Account;
import ru.surovcev.project.demotransaction.model.TransferRequest;
import ru.surovcev.project.demotransaction.repository.AccountRepository;
import ru.surovcev.project.demotransaction.service.TransferService;

import java.util.List;

@RestController("/account")
public class AccountController {
    private final AccountRepository accountRepository;
    private final TransferService transferService;

    public AccountController(AccountRepository accountRepository, TransferService transferService) {
        this.accountRepository = accountRepository;
        this.transferService = transferService;
    }

    @PostMapping("/add")
    public void storeAccount(@RequestBody Account account) {
        accountRepository.storeAccount(account);
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request){
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts(){
        return transferService.getAllAccounts();
    }
}
