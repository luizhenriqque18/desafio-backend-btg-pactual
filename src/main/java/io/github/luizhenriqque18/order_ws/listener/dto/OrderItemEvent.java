package io.github.luizhenriqque18.order_ws.listener.dto;

import java.math.BigDecimal;

public record OrderItemEvent(String produto,
                            Integer quantidade,
                            BigDecimal preco) {
}
