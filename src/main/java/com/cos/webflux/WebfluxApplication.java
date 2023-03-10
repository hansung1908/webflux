package com.cos.webflux;

import com.cos.webflux.reactivetest.MyTestPub;
import com.cos.webflux.reactivetest.MyTestSub;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Webflux = 단일 스레드, 비동기 + Stream을 통해 백프레셔가 적용된 데이터만큼 간헐적 응답이 가능하다 + 데이터 소비가 끝나면 응답이 종료
// SSE 적용 (Servlet, Webflux) = 데이터 소비가 끝나도 Stream 계속 유지
@SpringBootApplication
public class WebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxApplication.class, args);

		MyTestPub pub = new MyTestPub(); // 신문사 생성
		MyTestSub sub = new MyTestSub(); // 구독자 생성

		pub.subscribe(sub);
	}


}
