package io.github.luizhenriqque18.order_ws.controller;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.luizhenriqque18.order_ws.controller.dto.ApiResponse;
import io.github.luizhenriqque18.order_ws.controller.dto.OrderResponse;
import io.github.luizhenriqque18.order_ws.service.OrderService;

@RestController(value = "/api/v1")
@RequestMapping("/orders")
public class OrderController {
    
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderResponse>> findAllById(@PathVariable Long id) {
        var response = service.findAllByCustomerId(id);
        return ResponseEntity.ok(
            new ApiResponse<OrderResponse>(
            null,
            response.stream().map(OrderResponse::fromEntity).toList(),
            null
        ));
    }
}
