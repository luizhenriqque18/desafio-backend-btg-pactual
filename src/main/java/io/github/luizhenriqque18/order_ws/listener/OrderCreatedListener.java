package io.github.luizhenriqque18.order_ws.listener;

import org.springframework.messaging.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.luizhenriqque18.order_ws.listener.dto.OrderCreatedEvent;


@Component
public class OrderCreatedListener {
    
    private static final Logger logger = LoggerFactory.getLogger(OrderCreatedEvent.class);
    private static final String ORDER_CREATED_QUEUE = "btg-pactual-order-created";

    @RabbitListener(queues = ORDER_CREATED_QUEUE)
    public void listen(Message<OrderCreatedEvent> message) {
        logger.info("Message consumed {}", message);
    }
}
