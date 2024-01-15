package com.ahmed;

import com.ahmed.customer.Customer;
import com.ahmed.customer.CustomerRepository;
import com.ahmed.customer.Gender;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication
@RestController
public class Main {

    public static void main(String[] args) {


        SpringApplication. run(Main.class, args);


    }

//    @Bean
//    CommandLineRunner runner(CustomerRepository customerRepository) {
//        return args -> {
//
//            Customer Ahmed = new Customer("ahmed tarek", "ahmed.tarek@yahoo.com", 23, Gender.MALE);
//            //customers.add(Ahmed);
//            Customer Mo = new Customer("mo salah ", "mo.salah@yahoo.com", 23, Gender.MALE);
//            List<Customer> customers = List.of(Ahmed, Mo);
//            customerRepository.saveAll(customers);
//        };


    }







