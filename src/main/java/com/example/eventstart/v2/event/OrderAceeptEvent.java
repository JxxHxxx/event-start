package com.example.eventstart.v2.event;

import lombok.Getter;

@Getter
public class OrderAceeptEvent {
    private final Long ordererId;

    public OrderAceeptEvent(Long ordererId) {
        this.ordererId = ordererId;
    }
}
