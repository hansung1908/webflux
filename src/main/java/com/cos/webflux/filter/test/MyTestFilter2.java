package com.cos.webflux.filter.test;

import com.cos.webflux.filter.test.config.EventNotify;
import jakarta.servlet.*;
import java.io.IOException;

public class MyTestFilter2 implements Filter {

    private EventNotify eventNotify;

    public MyTestFilter2(EventNotify eventNotify) {
        this.eventNotify = eventNotify;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("필터2 실행");

        // 데이터를 하나 발생시켜서 지속적으로 반영
        eventNotify.add("새로운 데이터");
    }

}

