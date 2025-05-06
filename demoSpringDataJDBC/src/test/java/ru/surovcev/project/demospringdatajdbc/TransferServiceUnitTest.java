package ru.surovcev.project.demospringdatajdbc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.surovcev.project.demospringdatajdbc.model.Account;
import ru.surovcev.project.demospringdatajdbc.repository.AccountRepository;
import ru.surovcev.project.demospringdatajdbc.service.TransferService;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TransferServiceUnitTest {
    @Test
    @DisplayName("тест суммы, которая списывается с одного счёта и передаётся на другой счёт")
    public void moneyTransferHappyFlow() {
        /**
         * Объект-заглушка для объекта AccountRepository
         */
        AccountRepository accountRepository = mock(AccountRepository.class);

        /**
         * Создаём экземпляр объекта с методом, который хотим протестировать.
         */
        TransferService transferService = new TransferService(accountRepository);

        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account destination = new Account();
        destination.setId(2);
        destination.setAmount(new BigDecimal(1000));

        /**
         * given() - метод JUnit
         */
        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));

        given(accountRepository.findById(destination.getId())).willReturn(Optional.of(destination));

        transferService.transferMoney(
                sender.getId(),
                destination.getId(),
                new BigDecimal(100)
        );

        /**
         * Сообщаем тесту, что мы ожидаем получить
         */
        verify(accountRepository)
                .changeAmount(1L, new BigDecimal(900));

        verify(accountRepository)
                .changeAmount(2L, new BigDecimal(1100));
    }
}
