package ru.surovcev.project.demospringdatajdbc.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.surovcev.project.demospringdatajdbc.exceptions.AccountNotFoundException;
import ru.surovcev.project.demospringdatajdbc.model.Account;
import ru.surovcev.project.demospringdatajdbc.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Основной метод класса, отвечающий за перевод денег
     * @Transactional обеспечаивает атомарность операции
     * @param idSender
     * @param idReceiver
     * @param amount
     */
    @Transactional
    public void transferMoney(
            long idSender,
            long idReceiver,
            BigDecimal amount) {

        /**
         * создаём классы Account Для манипуляций c со счетами.
         * здесь для поиска отправителя и получателя используем методы интерфейса CrudRepository - findById(), это чтобы не писать в репозитории
         * кастомный метод для поиска по id (берём из коробки)
         */
        Account sender = accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());
        Account reciever = accountRepository.findById(idReceiver).orElseThrow(()-> new AccountNotFoundException());

        /**
         * Здесь используя геттер класса Amount для получения счёта меняем его используя методы класса BigDecimal - subtract() и add()
         */
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal recieverNewAmount = reciever.getAmount().add(amount);

        /**
         * А вот для замены значения в счёте мы уже дёргаем метод из репозитория (т.к тут коробочным уже не обойтись)
         *
         */
        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, recieverNewAmount);
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> findAccountsByName(String name) {
        return accountRepository.findAccountsByName(name);
    }
}
