package ru.surovcev.project.demotransaction.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.surovcev.project.demotransaction.model.Account;
import ru.surovcev.project.demotransaction.model.AccountRowMapper;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {

    /**
     * по примеру прошлого урока определяем SELECT-запросы, для внесения изменений и получения данных
     */

    private JdbcTemplate jdbc;
    public AccountRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Account> findAllAccounts() {
        String sql = "select * from account";
        return jdbc.query(sql, new AccountRowMapper());
    }

    /**
     * тут используем новый метод queryForObject() объекта JdbcTemplate
     * @param id
     * @return
     */
    public Account findAccountById(int id) {
        String sql = "select * from account where id = ?";
        return jdbc.queryForObject(sql, new AccountRowMapper(), id);
    }

    public void changeAmount(int id, BigDecimal amount) {
        String sql = "update account set amount = ? where id = ?";
        jdbc.update(sql, amount, id);
    }

    public void storeAccount(Account account) {
        String sql = "insert into account (owner_name, amount) values (?, ?)";
        jdbc.update(sql,
                account.getName(),
                account.getAmount());
    }
}
