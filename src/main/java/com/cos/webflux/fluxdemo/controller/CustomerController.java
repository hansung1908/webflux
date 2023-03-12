package com.cos.webflux.fluxdemo.controller;

import com.cos.webflux.fluxdemo.domain.Customer;
import com.cos.webflux.fluxdemo.repository.CustomerRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Data
@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/flux")
    public Flux<Integer> flux() {
        return  Flux.just(1,2,3,4,5).delayElements(Duration.ofSeconds(1)).log();
    }

    @GetMapping("/customer")
    public Flux<Customer> findAll() {
        return customerRepository.findAll().log();
    }
}
