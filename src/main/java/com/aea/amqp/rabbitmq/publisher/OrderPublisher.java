package com.aea.amqp.rabbitmq.publisher;

import com.aea.amqp.rabbitmq.config.MessagingConfig;
import com.aea.amqp.rabbitmq.dto.Order;
import com.aea.amqp.rabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        order.setOrderId(UUID.randomUUID().toString());
        // Restaurant Service
        // Payment Service
        OrderStatus orderStatus = new OrderStatus(order, "INPROGRESS", "Order placed successfully in " + restaurantName);
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
        return "Success !!!";
    }
}
