package com.example.eventstart.springevent.presentation;

import com.example.eventstart.springevent.dto.OrderForm;
import com.example.eventstart.springevent.application.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/v2/orders")
    public String create(@RequestBody OrderForm form) {
        orderService.create(form);
        return "주문 완료";
    }
}
