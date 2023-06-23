package com.example.eventstart.springevent.application;

import com.example.eventstart.springevent.MenuSoldOutException;
import com.example.eventstart.springevent.domain.Order;
import com.example.eventstart.springevent.domain.OrderRepository;
import com.example.eventstart.springevent.dto.OrderForm;
import com.example.eventstart.springevent.trigger.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final ApplicationEventPublisher eventPublisher;
    private final OrderRepository orderRepository;

    @Transactional
    public void create(OrderForm form) {
        log.info("주문 생성 로직 START");
        // 비즈니스 로직 시작
        if ("마라탕".equals(form.menuName())) {
            throw new MenuSoldOutException("해당 메뉴는 품절되었습니다.");
        }
        orderRepository.save(new Order(form.ordererId()));
        log.info("[주문 생성 - 주문 ID : {} 메뉴 : {} 주문자 ID : {}]", form.orderNo(), form.menuName(), form.ordererId());
        // 이벤트 Publish
        OrderCreatedEvent event = new OrderCreatedEvent(form.ordererId());
        eventPublisher.publishEvent(event);
        log.info("주문 생성 로직 END");
    }
}
