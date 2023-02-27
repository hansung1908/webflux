package com.cos.webflux.filtertest;

import com.cos.webflux.filtertest.config.EventNotify;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyTestFilter implements Filter {

    private EventNotify eventNotify;

    public MyTestFilter(EventNotify eventNotify) {
        this.eventNotify = eventNotify;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("필터 실행");

        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setContentType("text/event-stream; charset=UTF-8"); // event-stream이어야 실시간으로 나눠서 받아짐

        PrintWriter out = resp.getWriter();

        // 1. Reactive Streams 라이브러리를 쓰면 표준을 지켜서 응답 가능
        for(int i = 0; i < 5; i++) {
            out.print("응답 " + i + "\n");
            out.flush(); // 버퍼 비우기
            // reactive streams의 onNext() 메소드를 통해 한번에 몇개의 데이터를 보낼지 정할 수 있음
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 2. SSE Emitter 라이브러리를 쓰면 편하게 쓸 수 있음
        while(true) {
            try {
                if(eventNotify.isChange()) {
                    int lastIndex = eventNotify.getEvents().size() - 1;
                    out.print("응답 " + eventNotify.getEvents().get(lastIndex) + "\n");
                    out.flush(); // 버퍼 비우기
                    eventNotify.setChange(false);
                }
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 3. Webflux -> Reactive Streams가 적용된 stream을 배우고 (비동기 단일 스레드 동작)
        // 4. Servlet MVC -> Reactive Streams가 적용된 stream을 배우고 (멀티 스레드 동작)
    }
}

