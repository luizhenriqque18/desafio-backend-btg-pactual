package io.github.luizhenriqque18.order_ws.config;

import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RabbitMqConfig {
    public static final String ORDER_CREATED_QUEUE = "btg-pactual-order-created";


    @Bean
    public Jackson2JsonMessageConverter jackson2JsonDecoder() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Declarable orderCreatedQueue() {
        return new Queue(ORDER_CREATED_QUEUE);
    }
}