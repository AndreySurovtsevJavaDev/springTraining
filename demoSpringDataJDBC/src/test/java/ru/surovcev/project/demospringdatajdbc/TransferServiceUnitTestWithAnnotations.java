package ru.surovcev.project.demospringdatajdbc;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.surovcev.project.demospringdatajdbc.exceptions.AccountNotFoundException;
import ru.surovcev.project.demospringdatajdbc.model.Account;
import ru.surovcev.project.demospringdatajdbc.repository.AccountRepository;
import ru.surovcev.project.demospringdatajdbc.service.TransferService;

import java.math.BigDecimal;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * @ExtendWith нужна, чтобы работали @Mock И @injectMock
 */
@ExtendWith(MockitoExtension.class)
public class TransferServiceUnitTestWithAnnotations {
    /**
     * Здесь объявление моковых объектов вынесено за пределы метода.
     * Встретив аннотацию @Mock фреймворк создаёт объект-заглушку и внедряет его в атрибут, перед которым стоит аннотация
     */
    @Mock
    private AccountRepository accountRepository;

    /**
     * Встретив @InjecvtMock фреймворк создаёт тестируемый объект и внедряет все заглушки (созданные с помощью @Mock) в его параметры
     */
    @InjectMocks
    private TransferService transferService;

    @Test
    public void moneyTransferHappyFlow(){
        Account sender = new Account();
        sender.setId(1L);
        sender.setAmount(new BigDecimal(1000));

        Account destination = new Account();
        destination.setId(2L);
        destination.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(sender.getId()))
                .willReturn(Optional.of(sender));

        given(accountRepository.findById(destination.getId()))
                .willReturn(Optional.of(destination));

        transferService.transferMoney(1L, 2L, new BigDecimal(100));

        verify(accountRepository).changeAmount(1L, new BigDecimal(900));
        verify(accountRepository).changeAmount(2L, new BigDecimal(1100));
    }


    /**
     * Сценарий, для проверки работы исключения. Данные по одному из объектов не найдены.
     */
    @Test
    public void moneyTransferNotFoundFlow(){
        Account sender = new Account();
        sender.setId(1L);
        sender.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(sender.getId()))
                .willReturn(Optional.of(sender));

        /**
         * делает так, чтобы в моковом объекте возвращались пустые значения
         */
        given(accountRepository.findById(2L))
                .willReturn(Optional.empty());

        /**
         * assertThrows нужен, чтобы Убедиться, что код выбрасывает конкретное исключение, проверить тип исключения
         */
        assertThrows(
                AccountNotFoundException.class,
                ()-> transferService.transferMoney(1l, 2l, new BigDecimal(100))
        );

        /**
         * Условие never() нужно, чтобы быть уверенным, что метод changeAmount не вызывается
         */
        verify(accountRepository, never())
                .changeAmount(anyLong(), any());
    }
}
