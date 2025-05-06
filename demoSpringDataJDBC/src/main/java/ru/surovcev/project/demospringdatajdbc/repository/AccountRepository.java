package ru.surovcev.project.demospringdatajdbc.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.surovcev.project.demospringdatajdbc.model.Account;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query(value = "SELECT * FROM account a"
            + "WHERE a.ownerName = :ownerName")
    List<Account> findAccountsByName(String ownerName);

    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void changeAmount(Long id, BigDecimal amount);
}
