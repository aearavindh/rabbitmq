package com.aea.amqp.rabbitmq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {
    private Order order;
    private String status; //INPROGRESS, COMPLETED
    private String message;
}
