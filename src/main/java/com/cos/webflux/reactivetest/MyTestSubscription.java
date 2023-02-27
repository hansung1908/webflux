package com.cos.webflux.reactivetest;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;

// 구독 정보 (구독자, 구독 데이터)
public class MyTestSubscription implements Subscription {

    private Subscriber s;
    private Iterator<Integer> it;

    public MyTestSubscription(Subscriber s, Iterable<Integer> its) {
        this.s = s;
        this.it = its.iterator();
    }

    @Override
    public void request(long n) { // 1 (시작 지점)
        while(n > 0) {
            if(it.hasNext()) {
                s.onNext(it.next()); // 1,2,3,4,5,6,7,8,9,10 (순차적으로 증가)
            } else {
                s.onComplete(); // 끝
                break;
            }
            n--;
        }
    }

    @Override
    public void cancel() {

    }
}
