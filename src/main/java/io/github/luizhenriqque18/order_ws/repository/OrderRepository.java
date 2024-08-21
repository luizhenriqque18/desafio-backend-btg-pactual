package io.github.luizhenriqque18.order_ws.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.luizhenriqque18.order_ws.entity.OrderEntity;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
    
}
