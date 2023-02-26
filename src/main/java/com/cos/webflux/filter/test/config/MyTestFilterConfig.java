package com.cos.webflux.filter.test.config;

import com.cos.webflux.filter.test.MyTestFilter;
import com.cos.webflux.filter.test.MyTestFilter2;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyTestFilterConfig {

    @Autowired
    private EventNotify eventNotify;

    @Bean
    public FilterRegistrationBean<Filter> addFilter() {

        System.out.println("필터 등록");

        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyTestFilter(eventNotify));
        bean.addUrlPatterns("/sse");

        return bean;
    }

    @Bean
    public FilterRegistrationBean<Filter> addFilter2() {

        System.out.println("필터2 등록");

        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyTestFilter2(eventNotify));
        bean.addUrlPatterns("/add");

        return bean;
    }
}
