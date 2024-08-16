package io.github.luizhenriqque18.order_ws.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.math.BigDecimal;


@Document(collection = "tb_orders")
public class OrderEntity {
    
    @MongoId
    private Long orderId;

    @Indexed(name="customer_id_index")
    private Long customerId;
    
    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal total;
    
    private List<OrderItemEntity> items;

    public Long getOrderId() {
        return orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<OrderItemEntity> getItems() {
        return items;
    }
}
