package io.github.luizhenriqque18.order_ws.listener;

import org.springframework.messaging.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.luizhenriqque18.order_ws.listener.dto.OrderCreatedEvent;
import io.github.luizhenriqque18.order_ws.service.OrderService;


@Component
public class OrderCreatedListener {
    
    private static final Logger logger = LoggerFactory.getLogger(OrderCreatedEvent.class);
    private static final String ORDER_CREATED_QUEUE = "btg-pactual-order-created";
    private final OrderService orderService;

    public OrderCreatedListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = ORDER_CREATED_QUEUE)
    public void listen(Message<OrderCreatedEvent> message) {
        logger.info("Message consumed {}", message.getPayload());
        orderService.save(message.getPayload());
    }
}
