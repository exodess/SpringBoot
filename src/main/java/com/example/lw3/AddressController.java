package com.example.lw3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class AddressController {
    private final ConcurrentMap<String, String> addressBook = new ConcurrentHashMap<>();

    @PostMapping("/addresses")
    public void postAddress(@RequestParam String name, @RequestParam String address) {
        addressBook.put(name, address);
    }

    @GetMapping("/addresses")
    public ConcurrentMap<String, String> getAddressBook() {
        return addressBook;
    }

    @DeleteMapping("/addresses")
    public String removeAddress(@RequestParam String name) {
        addressBook.remove(name);
        return name + " removed from address book!";
    }

    @GetMapping("/getPassword")
    String getPassword(@Autowired PasswordGenerator gen) {
        return gen.generate(10);
    }

    @PostMapping("/getPassword")
    String getPassword(@Autowired PasswordGenerator gen, @RequestParam int length) {

        if(length > 100) {
            throw new RuntimeException();
        }

        return gen.generate(length);
    }

    @PostMapping("/getPassword")
    ApiResponse getPassword(@Autowired PasswordGenerator gen, @RequestParam String length) {
        return new ApiResponse(false, "Поле length должно быть числовым!");
    }
}
