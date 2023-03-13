package com.cos.webflux.web;

import com.cos.webflux.fluxdemo.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

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

    }
}
