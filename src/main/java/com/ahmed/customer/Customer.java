package com.ahmed.customer;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public  class Customer{
    public Customer(String name) {
        this.name = name;
    }

    @Id
   @SequenceGenerator( name = "customer_id" ,sequenceName = "customer_id" )
   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_id")
    private int id ;

   @Column(name = "customer_name")
    private String name;

    public Customer() {
    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}