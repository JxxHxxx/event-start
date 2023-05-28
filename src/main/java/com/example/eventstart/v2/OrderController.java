package com.example.eventstart.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/orders")
    public void Orders(@RequestParam("orderer") Long ordererId) {
        Order order = new Order(1l, ordererId);
        order.accept();
    }
}
