package ru.surovcev.project.demospringdatajdbc;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.surovcev.project.demospringdatajdbc.model.Account;
import ru.surovcev.project.demospringdatajdbc.repository.AccountRepository;
import ru.surovcev.project.demospringdatajdbc.service.TransferService;

import java.math.BigDecimal;
import java.util.Optional;


import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransferServiceUnitTestWithAnnotations {
    @Mock
    private AccountRepository accountRepository;

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
}
