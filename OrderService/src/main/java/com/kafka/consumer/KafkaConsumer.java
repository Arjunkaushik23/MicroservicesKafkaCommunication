package com.kafka.consumer;


import com.kafka.entity.InventoryEntity;
import com.kafka.service.OrderEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    public KafkaConsumer(OrderEntityService orderEntityService) {
        this.orderEntityService = orderEntityService;
    }

    private final OrderEntityService orderEntityService;

    @KafkaListener(topics = "order-inventory-topic", groupId = "order-group")
    public  void consumeInventoryMessage(InventoryEntity inventoryEntity) {
        orderEntityService.updateOrderWithInventory(inventoryEntity);
    }
}
