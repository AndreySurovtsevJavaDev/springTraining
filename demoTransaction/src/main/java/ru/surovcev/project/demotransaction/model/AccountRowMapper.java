package ru.surovcev.project.demotransaction.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Реализуем контракт RowMapper и передаём ему в качестве параметризованного типа класс модели, в которую будет преобразована строка результата
 * До этого мы делали похожую процедуру прямо в репозитории
 */
public class AccountRowMapper implements RowMapper<Account> {

    /**
     * Реализуем метод интерфейса RowMapper mapRow(), принимающий аргументом строку результата в виде объекта ResultSet
     * и возвращающий экземпляр Account, в который преобразуется текущая строка
     * @param resultSet
     * @param i
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        /**
         * преобразуем значения текущей строки результата в атрибуты Account
         */
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("owner_name"));
        account.setAmount(resultSet.getBigDecimal("amount"));
        return account;
    }
}
