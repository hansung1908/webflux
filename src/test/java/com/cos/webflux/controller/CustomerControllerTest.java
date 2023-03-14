package com.cos.webflux.controller;

import com.cos.webflux.fluxdemo.domain.Customer;
import com.cos.webflux.fluxdemo.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

// 통합 테스트
// @SpringBootTest

//
@WebFluxTest
public class CustomerControllerTest {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void findById_test() {

        // given
        Mono<Customer> givenData = Mono.just(new Customer("Jack", "Bauer"));

        // stub -> 행동지시
        when(customerRepository.findById(1L)).thenReturn(givenData);

        webTestClient.get().uri("/customer/{id}", 1L)
                .exchange()
                .expectBody()
                .jsonPath("$.firstName").isEqualTo("Jack")
                .jsonPath("$.lastName").isEqualTo("Bauer");
    }
}
