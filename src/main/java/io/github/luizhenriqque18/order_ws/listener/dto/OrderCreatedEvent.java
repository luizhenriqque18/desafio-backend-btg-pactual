package io.github.luizhenriqque18.order_ws.listener.dto;

import java.util.List;

public record OrderCreatedEvent(Long codigoPedidp,
                                Long codigoCliente,
                                List<OrderItemEvent> items) {

}