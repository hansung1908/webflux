package com.cos.webflux.reactivetest;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.Arrays;

public class MyTestPub implements Publisher<Integer> {

    Iterable<Integer> its = Arrays.asList(1,2,3,4,5,6,7,8,9,10); // 보낼 수 있는 최대 갯수

    @Override
    public void subscribe(Subscriber<? super Integer> s) {
        System.out.println("구독자 신문 구독 요청");
        System.out.println("신문사 구독 정보 생성 대기");
        MyTestSubscription subscription = new MyTestSubscription(s, its);
        System.out.println("구독 정보 생성 완료 후 리턴");
        s.onSubscribe(subscription);
    }
}
