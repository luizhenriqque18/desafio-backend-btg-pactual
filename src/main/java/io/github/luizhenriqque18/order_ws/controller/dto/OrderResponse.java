package io.github.luizhenriqque18.order_ws.controller.dto;

import java.math.BigDecimal;

import io.github.luizhenriqque18.order_ws.entity.OrderEntity;

public record OrderResponse(
        Long orderId,
        Long customerId,
        BigDecimal total) {
    
    
    public static OrderResponse fromEntity(OrderEntity entity) {
        return new OrderResponse(entity.getOrderId(), entity.getCustomerId(), entity.getTotal());
    }
}
