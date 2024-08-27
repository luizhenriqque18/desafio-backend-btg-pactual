package io.github.luizhenriqque18.order_ws.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.github.luizhenriqque18.order_ws.listener.dto.OrderCreatedEvent;
import io.github.luizhenriqque18.order_ws.repository.OrderRepository;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTests {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService;
    
    @Nested
    class Save {
        @Test
        void shouldCallRepositorySave() {
            OrderCreatedEvent order = new OrderCreatedEvent(1L, 1L, List.of());
            orderService.save(order);
            verify(orderRepository, times(1)).save(any());
        }
    }
}
