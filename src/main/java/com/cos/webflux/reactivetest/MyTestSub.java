package com.cos.webflux.reactivetest;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MyTestSub implements Subscriber<Integer> {

    private Subscription s;
    private int bufferSize = 2; // 2번 실행

    @Override
    public void onSubscribe(Subscription s) {
        System.out.println("구독자 구독 정보 도착");
        this.s = s;
        System.out.println("구독자 신문 매일 bufferSize만큼 배달 요청");
        s.request(bufferSize); // 신문 bufferSize만큼 배달 요청 (백프레셔 : 소비자가 한번에 처리할 수 있는 갯수 요청)
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("onNext() : " + integer);

        bufferSize--; // 2 -> 1 -> 0 -> 2 ...

        if(bufferSize == 0) {
            System.out.println("하루 경과");
            bufferSize = 2;
            s.request(bufferSize);
        }
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("구독중 에러");
    }

    @Override
    public void onComplete() {
        System.out.println("구독 완료");
    }
}
