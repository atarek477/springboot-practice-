package com.ahmed.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;

class CustomerDaoJDBCTest extends AbstractTestContainer{
 private CustomerDaoJDBC customerDaoJDBC ;
 private final CustomerRowMapper customerRowMapper = new CustomerRowMapper();
    @BeforeEach
    void setUp() {
        customerDaoJDBC =new CustomerDaoJDBC(new JdbcTemplate(getDataSource()),customerRowMapper);
    }

    @Test
    void getAllCustomerDao() {
       Customer customer =new Customer("ahmed tarek","ahmed.tare@yahoo.com",33, Gender.MALE);
       customerDaoJDBC.addCustomerDao(customer);
       List<Customer> customers= customerDaoJDBC.getAllCustomerDao();
       assertThat(customers).isNotEmpty();

    }

    @Test
    void getCustomerByIdDao() {
       Customer customer =new Customer("alex tarek","alex.tare@yahoo.com",33, Gender.MALE);
       customerDaoJDBC.addCustomerDao(customer);
       List<Customer> customers= customerDaoJDBC.getAllCustomerDao();
       int id = customers.stream().filter(c->c.getEmail().equals("alex.tare@yahoo.com"))
               .map(Customer::getId).findFirst().orElseThrow();
       Optional<Customer> customerByIdDao = customerDaoJDBC.getCustomerByIdDao(id);
       assertThat(customerByIdDao).isPresent().hasValueSatisfying(c->{
          assertThat(c.getId()==id);
          assertThat(c.getName().equals(customer.getName()));
          assertThat(c.getEmail().equals(customer.getEmail()));
          assertThat(c.getAge()==customer.getAge());

       });



    }

    @Test
    void addCustomerDao() {
       Customer customer =new Customer("alex john","al.john@yahoo.com",76, Gender.MALE);
       customerDaoJDBC.addCustomerDao(customer);
       List<Customer> customers= customerDaoJDBC.getAllCustomerDao();

       int id = customers.stream().filter(c->c.getEmail().equals(customer.getEmail()))
               .map(Customer::getId).findFirst().orElseThrow();
       Optional<Customer> customerByIdDao = customerDaoJDBC.getCustomerByIdDao(id);
       assertThat(customerByIdDao).isPresent().hasValueSatisfying(c->{
          assertThat(c.getId()==id);
          assertThat(c.getName().equals(customer.getName()));
          assertThat(c.getEmail().equals(customer.getEmail()));
          assertThat(c.getAge()==customer.getAge());
       });
    }

    @Test
    void updateCustomerDao() {


       

    }

    @Test
    void deleteCustomerByIdDao() {
       Customer customer =new Customer("juu john","al.johhh@yahoo.com",76, Gender.MALE);
       customerDaoJDBC.addCustomerDao(customer);
       List<Customer> customers= customerDaoJDBC.getAllCustomerDao();

       int id = customers.stream().filter(c->c.getEmail().equals(customer.getEmail()))
               .map(Customer::getId).findFirst().orElseThrow();
       customerDaoJDBC.deleteCustomerByIdDao(id);
       assertThat(customerDaoJDBC.getCustomerByIdDao(id)).isNotPresent();
    }
}