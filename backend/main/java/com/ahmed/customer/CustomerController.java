package com.ahmed.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
private final CustomerServices customerServices ;

    public CustomerController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }


    @GetMapping("api/v1/customer")
    public List<Customer> getAllCustomerController(){
        return customerServices.getAllCustomer();


    }


    @GetMapping("api/v1/customer/{id}")
    public Optional<Customer> getCustomerByIdController(@PathVariable("id") Integer id){
        return customerServices.getCustomerById(id);

    }
    @PostMapping("api/v1/customer/save")
    public void addCustomerController(@RequestBody Customer customer){
        customerServices.addCustomer(customer);
    }
    @PostMapping("api/v1/customer/update/{id}")
    public void updateCustomerController(@PathVariable("id") Integer id,@RequestBody RequestUpdate requestUpdate){
        customerServices.updateCustomer( requestUpdate, id);
    }


    @DeleteMapping("api/v1/customer/delete/{id}")
    public void deleteCustomerByIdController(@PathVariable("id") Integer id){
        customerServices.deleteCustomerById(id);

    }

}
