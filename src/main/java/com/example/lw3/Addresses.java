package com.example.lw3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Addresses {

    @Bean("address1")
    public String address1() {
        return "Green Street, 102";
    }

    @Bean("address2")
    public String address2() {
        return "Apple Street, 15";
    }

    @Bean("customer")
    public Customer customer(@Qualifier("address2") String address) {
        return new Customer("Clara Foster", address);
    }

    @Bean("temporary")
    public Customer temporary(@Qualifier("customer") Customer customer) {
        System.out.println(customer);
        return customer;
    }
}
