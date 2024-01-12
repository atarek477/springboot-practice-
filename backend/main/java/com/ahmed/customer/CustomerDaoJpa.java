package com.ahmed.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa")
public class CustomerDaoJpa implements ICustomerDao{

    CustomerRepository customerRepository;
    static List<Customer> customers;

    public CustomerDaoJpa(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomerDao() {
       customers= customerRepository.findAll();
       return customers;
    }

    @Override
    public Optional<Customer> getCustomerByIdDao(Integer id) {
    return   customerRepository.findById(id);

    }



    @Override
    public void addCustomerDao(Customer customer) {

            customerRepository.save(customer);


    }

    @Override
    public void updateCustomerDao(RequestUpdate requestUpdate,Integer id) {
//  todo      Customer referenceById = customerRepository.getReferenceById(customer.getId());
//if(!referenceById.getName().equals(customer.getName())){
//referenceById.setName(customer.getName());
//        customerRepository.save(referenceById);
//}
    }

    @Override
    public void deleteCustomerByIdDao(Integer id) {
           customerRepository.deleteById(id);
    }
}
