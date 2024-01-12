package com.ahmed.customer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository("JDBC")
public class CustomerDaoJDBC implements ICustomerDao {

    private final JdbcTemplate jdbcTemplate;
    private final  CustomerRowMapper customerRowMapper;

    public CustomerDaoJDBC(JdbcTemplate jdbcTemplate, CustomerRowMapper customerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRowMapper = customerRowMapper;
    }

    @Override
    public List<Customer> getAllCustomerDao() {

        var sql = """
                SELECT id,name,email,age FROM customer
                """;


        return jdbcTemplate.query(sql,customerRowMapper);
    }

    @Override
    public Optional<Customer> getCustomerByIdDao(Integer id) {
        var sql ="""
                SELECT id,name,email,age FROM customer WHERE id = ?
                 """;
      return   jdbcTemplate.query(sql,customerRowMapper,id).stream().findFirst();

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
    public void updateCustomerDao(RequestUpdate requestUpdate,Integer id) {
        if(requestUpdate.name()!=null){
            var sql = """
                    UPDATE customer SET name =? WHERE id= ?
                    """;
            jdbcTemplate.update(sql,requestUpdate.name(),id);


        }
        if(requestUpdate.email()!=null){
            var sql = """
                    UPDATE customer SET email =? WHERE id= ?
                    """;
            jdbcTemplate.update(sql,requestUpdate.email(),id);


        }
        if(requestUpdate.age()!=0){
            var sql = """
                    UPDATE customer SET age=? WHERE id= ?
                    """;
            jdbcTemplate.update(sql,requestUpdate.age(),id);


        }



    }



    @Override
    public void deleteCustomerByIdDao(Integer id) {
        var sql = """
                DELETE FROM customer WHERE id = ?
                """;
        jdbcTemplate.update(sql,id);
    }
}
