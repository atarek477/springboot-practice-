package com.ahmed.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository("List")
public class CustomerDao implements ICustomerDao {
    static List<Customer> customers;

    @Override
    public List<Customer> getAllCustomerDao(){

        return customers;
    }

    @Override
    public Optional<Customer> getCustomerByIdDao(Integer id) {
       return  customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst();


    }


    @Override
    public void addCustomerDao(Customer customer) {return;

    }

    @Override
    public void updateCustomerDao(RequestUpdate requestUpdate,Integer id) {

    }

    @Override
    public void deleteCustomerByIdDao(Integer id) {



    }
}
