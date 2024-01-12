package com.ahmed.customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerDao {

     List<Customer> getAllCustomerDao();
     Optional<Customer> getCustomerByIdDao(Integer id);


     void addCustomerDao(Customer customer);
     void updateCustomerDao(RequestUpdate requestUpdate,Integer id);

     void deleteCustomerByIdDao(Integer id);

}
