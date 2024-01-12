package com.ahmed.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class CustomerDaoJpaTest {
private CustomerDaoJpa customerDaoJpa;
private  AutoCloseable autoCloseable;

@Mock
private CustomerRepository customerRepository;
    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        customerDaoJpa= new CustomerDaoJpa(customerRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getAllCustomerDao() {
        customerDaoJpa.getAllCustomerDao();
        Mockito.verify(customerRepository).findAll();
    }

    @Test
    void getCustomerByIdDao() {
     int id = 1;
     customerDaoJpa.getCustomerByIdDao(id);
     Mockito.verify(customerRepository).findById(id);




    }

    @Test
    void addCustomerDao() {
        Customer customer= new Customer(2,"ahmed tarek", "ahmed.tarek@gmail.com",34);
        customerDaoJpa.addCustomerDao(customer);
        Mockito.verify(customerRepository).save(customer);
    }

    @Test
    void deleteCustomerByIdDao() {
        int id = 1;
        customerDaoJpa.deleteCustomerByIdDao(id);
        Mockito.verify(customerRepository).deleteById(id);

    }
}