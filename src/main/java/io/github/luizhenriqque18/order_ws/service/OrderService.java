package io.github.luizhenriqque18.order_ws.service;

import org.springframework.stereotype.Service;

import io.github.luizhenriqque18.order_ws.entity.OrderEntity;
import io.github.luizhenriqque18.order_ws.entity.OrderItem;
import io.github.luizhenriqque18.order_ws.listener.dto.OrderCreatedEvent;
import io.github.luizhenriqque18.order_ws.listener.dto.OrderItemEvent;
import io.github.luizhenriqque18.order_ws.repository.OrderRepository;

import java.util.List;
import java.util.Set;
import java.math.BigDecimal;

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
        entity.setItems(getTotal(event.itens()));
        entity.setTotal(calcTotal(event.itens()));

        repository.save(entity);
    }

    private BigDecimal calcTotal(List<OrderItemEvent> item) {
        return item.stream()
        .map(i -> i.preco().multiply(BigDecimal.valueOf(i.quantidade())))
        .reduce(BigDecimal::add)
        .orElse(BigDecimal.ZERO);
    }

    private List<OrderItem> getTotal(List<OrderItemEvent> listForDto) {
        return listForDto.stream().map(OrderItem::convertToEntity).toList();
    }

    public Set<OrderEntity> findAllByCustomerId(Long id) {
        return repository.findAllByCustomerId(id);
    }
}
