package io.github.luizhenriqque18.order_ws.config;

import org.springframework.context.annotation.Configuration;

@Configuration
class RabbitMqConfig {
    public static final String ORDER_CREATED_QUEUE = "btg-pactual-order-created";
}