package com.ahmed.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CustomerServicesTest {

    @Mock
    private ICustomerDao iCustomerDao;
    private CustomerServices customerServices;

    @BeforeEach
    void setUp() {
        customerServices= new CustomerServices(iCustomerDao);
    }

    @Test
    void getAllCustomer() {
        customerServices.getAllCustomer();
        Mockito.verify(iCustomerDao).getAllCustomerDao();
    }

    @Test
    void getCustomerById() {
        int id =5;
        Customer customer= new Customer(id,"ahmed tarek", "ahmed.tarek@gmail.com",34);
        Mockito.when(iCustomerDao.getCustomerByIdDao(id)).thenReturn(Optional.of(customer));
        Optional<Customer> customerById = customerServices.getCustomerById(id);
       assertThat(customerById).isPresent()
       ;
    }

    @Test
    void addCustomer() {
        int id=7;
        Customer customer= new Customer(id,"ahmed tarek", "ahmed.tarek@gmail.com",34);

        customerServices.addCustomer(customer);
        Mockito.verify(iCustomerDao).addCustomerDao(customer);


    }


}