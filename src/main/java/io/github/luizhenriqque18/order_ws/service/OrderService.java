package io.github.luizhenriqque18.order_ws.service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import io.github.luizhenriqque18.order_ws.entity.OrderEntity;
import io.github.luizhenriqque18.order_ws.listener.dto.OrderCreatedEvent;
import io.github.luizhenriqque18.order_ws.repository.OrderRepository;

@Service
public class OrderService {
    
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {

        this.repository = repository;
    }

    public void save(OrderCreatedEvent event) {
        OrderEntity entity = new OrderEntity();

        entity.setOrderId(event.codigoPedido());
        entity.setCustomerId(event.codigoCliente());

        repository.save(entity);
    }
}
