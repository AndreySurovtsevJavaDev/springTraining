package ru.surovcev.project.demotransaction.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.surovcev.project.demotransaction.model.Account;
import ru.surovcev.project.demotransaction.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    private final AccountRepository accountRepository;
    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(int idSender,
                              int idReceiver,
                              BigDecimal amount) {
        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);

        /**
         * subtract И add - методы класса BigDecimal для вычитания и, соответственно, прибавления
         */
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);

        /**
         * проверка: работает ли транзакция и откатятся ли изменения, если что-то пошло не так.
         */
//        throw new RuntimeException("something went wrong");
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}
