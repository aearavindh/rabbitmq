package com.aea.amqp.rabbitmq.consumer;

import com.aea.amqp.rabbitmq.config.MessagingConfig;
import com.aea.amqp.rabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message received from Queue " + orderStatus);
    }

}
