package io.github.luizhenriqque18.order_ws.entity;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import io.github.luizhenriqque18.order_ws.listener.dto.OrderItemEvent;

public class OrderItemEntity {

    private String product;

    private Integer quantity;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal price;


    public OrderItemEntity(String produto, Integer quantidade, BigDecimal preco) {
        this.product = produto;
        this.quantity = quantidade;
        this.price = preco;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static OrderItemEntity convertToEntity(OrderItemEvent dto) {
        return new OrderItemEntity(dto.produto(), dto.quantidade(), dto.preco());
    }
}