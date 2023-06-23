package com.example.eventstart.springevent.notification.application;

import com.example.eventstart.springevent.dto.OrderForm;
import com.example.eventstart.springevent.notification.domain.Notification;
import com.example.eventstart.springevent.notification.domain.NotificationRepository;
import com.example.eventstart.springevent.trigger.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationEventHandler {

    private final NotificationRepository notificationRepository;

    /**
     * 이벤트 퍼블리셔가 포함된 로직에서 트랜잭션이 커밋되어야지만 이벤트가 호출된다.
     * EventListener를 사용할 때는 이벤트 호출 시점을 신경쓰거나 롤백에 따른 처리를 했어야 됐는데 그 점을 생략할 수 있다.
     */
    @TransactionalEventListener(classes = OrderCreatedEvent.class, phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handle(OrderCreatedEvent event) {
        if (event.ordererId() == 9999l) {
            log.info("알림 발송 중 예외가 발생했습니다.");
            throw new IllegalArgumentException("존재하지 않는 회원 식별자입니다");
        }
        Notification notification = new Notification(event.ordererId(), "주문 완료 메시지");
        notificationRepository.save(notification);

        log.info("[알림 수신자 ID : {} 요청하신 주문이 완료되었습니다.]", event.ordererId());
    }
}
