package ru.surovcev.project.demojdbctemplate.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.surovcev.project.demojdbctemplate.model.Purchase;

import java.util.List;

/**
 * Добавляем бин этого типа в контекст с помощью @Repository
 */
@Repository
public class PurchaseRepository {
    /**
     * Внедряем экземпляр класса jdbcTemplate для работы с БД
     * Данный класс создаётся спринг бутом при внедрении зависимости с СУБД (в нашем случае с Postgress, по книжке - с H2)
     */
    private final JdbcTemplate jdbc;

    /**
     * Используем внедрение в конструкторе, чтобы получить экземпляр jdbcTemplate из контекста приложения
     * @param jdbc
     */
    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void storePurchase(Purchase purchase) {  // в качестве параметра метод принимает данные, которые нужно сохранить
        /**
         * Запрос представляет собой строку, в которой вместо занчений параметров стоят "?" и вместо id ставим null, т.к СУБД его автоинкрементит
         */
        String sql = "INSERT INTO purchase (product, price) VALUES (?, ?)";
        /**
         * метод update экземпляра JdbcTemplate посылает запрос на сервер БД. первый параметр - это сам запрос, а остальное - значения параметров запроса
         */
        jdbc.update(sql,
                purchase.getProduct(),
                purchase.getPrice());
    }

    /**
     * Метод возвращает записи полученные из БД в виде списка объектов Purchase
     * @return
     */
    public List<Purchase> findAllPurchase(){
        /**
         * Определяем SELECT-запрос для получения всех записей из таблицы purchase БД
         */
        String sql = "SELECT * FROM purchase";

        /**
         * создаём объект RowMapper, которые сообщает JdbcTemplate как преобразовать строку полученную из БД в объект Purchase
         * Параметр "r" лямбда выражения соответсвует ResultSet(данным полученным из базы), а параметр "i" - целое число, показывающее номер строки
         */
        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            /**
             * Заносим данные в экземпляр Purchase. Логика будет выполняться для каждой строки из набора результатов
             */
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };
        /**
         * Отправляем Select-запрос, используем метод query(), и передаём объект преобразователя строк
         * чтобы JdbcTemplate знал, как преобразовать полученные данные в объект Purchase
         */
        return jdbc.query(sql, purchaseRowMapper);
    }
}
