package com.example.eventstart.v2;

import com.example.eventstart.v2.event.OrderAceeptEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Slf4j
@Service
public class notificationHandler {

    @EventListener
    public void handle(OrderAceeptEvent event) {
        notificationHandleTime();
        log.info("주문자 정보 {} 알림 시간 {}", event.getOrdererId(), LocalTime.now());
    }

    private static void notificationHandleTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
