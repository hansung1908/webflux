package com.cos.webflux.fluxdemo.controller;

import com.cos.webflux.fluxdemo.domain.Customer;
import com.cos.webflux.fluxdemo.repository.CustomerRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Data
@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/customer")
    public Flux<Customer> findAll() {
        return customerRepository.findAll().log();
    }
}
