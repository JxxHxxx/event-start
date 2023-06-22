package com.example.eventstart.springevent.application;

import com.example.eventstart.springevent.trigger.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class OrderEventHandler {
    /**
     * 이벤트 퍼블리셔가 포함된 로직에서 트랜잭션이 커밋되어야지만 이벤트가 호출된다.
     * EventListener를 사용할 때는 이벤트 호출 시점을 신경쓰거나 롤백에 따른 처리를 했어야 됐는데 그 점을 생략할 수 있다.
     */
    @TransactionalEventListener(classes = OrderCreatedEvent.class, phase = TransactionPhase.AFTER_COMMIT)
//    @EventListener(classes = OrderCreatedEvent.class)
    public void handle(OrderCreatedEvent event) {
        log.info("[알림 수신자 ID : {} 요청하신 주문이 완료되었습니다.]", event.ordererId());
    }
}
