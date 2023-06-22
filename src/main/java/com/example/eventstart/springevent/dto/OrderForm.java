package com.example.eventstart.springevent.dto;

public record OrderForm(
        Long orderNo,
        Long ordererId,
        String menuName) {
}
