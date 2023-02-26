package com.cos.webflux.filter.test.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Component
public class EventNotify {

    private List<String> events = new ArrayList<>();
    private boolean change = false;

    public void add(String data) {
        events.add(data);
        change= true;
    }
}
