package com.ahmed.customer;

import org.hibernate.sql.Update;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository("JDBC")
public class CustomerDaoJDBC implements ICustomerDao {

    private final JdbcTemplate jdbcTemplate;

    public CustomerDaoJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> getAllCustomerDao() {
        return null;
    }

    @Override
    public Optional<Customer> getCustomerByIdDao(Integer id) {
        return Optional.empty();
    }

    @Override
    public void addCustomerDao(Customer customer) {
        var sql  = """
                INSERT INTO customer (name ,email,age) VALUES (?,?,?)
                """;
        int update = jdbcTemplate.update(sql, customer.getName(), customer.getEmail(), customer.getAge());
        System.out.println("result"+update);

    }

    @Override
    public void updateCustomerDao(Customer customer) {

    }
}
