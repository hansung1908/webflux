package com.cos.webflux.domain;

import com.cos.webflux.fluxdemo.repository.CustomerRepository;
import com.cos.webflux.fluxdemo.utils.DBinit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;
import reactor.test.StepVerifier;

@DataR2dbcTest
@Import(DBinit.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findById_test() {
        StepVerifier
                .create(customerRepository.findById(2L))
                .expectNextMatches((c) -> {
                    return c.getFirstName().equals("Chloe");
                })
                .expectComplete()
                .verify();
    }
}
