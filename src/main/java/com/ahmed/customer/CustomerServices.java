package com.ahmed.customer;

import com.ahmed.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices {
    private final ICustomerDao icustomerDao;



    public CustomerServices(@Qualifier("jpa") ICustomerDao icustomerDao) {
        this.icustomerDao = icustomerDao;
    }

    public List<Customer> getAllCustomer(){
        return icustomerDao.getAllCustomerDao();
    }

    public Optional<Customer> getCustomerById(Integer id){

        return Optional.ofNullable(icustomerDao.getCustomerByIdDao(id)
                .orElseThrow(() -> new ResourceNotFound("customer with id [%s] not found".formatted(id))));
    }

    public void addCustomer(Customer customer){
        icustomerDao.addCustomerDao(customer);

    }
}
