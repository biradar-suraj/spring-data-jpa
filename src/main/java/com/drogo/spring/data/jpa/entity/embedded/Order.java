package com.drogo.spring.data.jpa.entity.embedded;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "order_tbl"
)
public class Order {

    @EmbeddedId
    private OrderId orderId;
    private String orderInfo;
    private BigDecimal totalAmount;

    @Embedded
    private DeliveryAddress deliveryAddress;

    @Column(
            name = "status"
    )
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public enum OrderStatus {
        PENDING,
        PROCESSING,
        SHIPPED,
        DELIVERED,
        CANCELLED
    }
}
