package com.example.eventstart.v2;

import com.example.eventstart.v2.event.Events;
import com.example.eventstart.v2.event.OrderAceeptEvent;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;

@Slf4j
@Getter
public class Order {
    private Long orderNo;
    private Long ordererId;
    private LocalTime orderTime;

    public Order(Long orderNo,Long ordererId) {
        this.orderNo = orderNo;
        this.ordererId = ordererId;
        this.orderTime = LocalTime.now();
    }

    public void accept()  {
        log.info("주문이 접수되었습니다. 주문 번호 {} 주문 시간 {}", orderNo, orderTime);
        Events.raise(new OrderAceeptEvent(ordererId));
    }
}
