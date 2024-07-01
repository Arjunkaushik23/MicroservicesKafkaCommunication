package com.kafka.consumer;

import com.kafka.entitiy.OrderEntity;
import com.kafka.service.UserEntityService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private final UserEntityService userEntityService;

    public KafkaConsumer(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @KafkaListener(topics = "user-order-topic", groupId = "order-group")
    public void consumeUserOrderMessage(OrderEntity orderEntity) {
        userEntityService.updateOrdersForUser(orderEntity);
    }


}
