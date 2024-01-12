package com.ahmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;


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
//            Customer Ahmed = new Customer("ahmed tarek", "ahmed.tarek@yahoo.com", 23);
//            //customers.add(Ahmed);
//            Customer Mo = new Customer("mo salah ", "mo.salah@yahoo.com", 23);
//            List<Customer> customers = List.of(Ahmed, Mo);
//            customerRepository.saveAll(customers);
//        };
//
//
//    }

}



