package com.kafka.service;

import com.kafka.entity.InventoryEntity;
import com.kafka.repository.InventoryEntityRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryEntityService {

    private static final String INVENTORY_TOPIC = "order-inventory-topic";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private final InventoryEntityRepository inventoryEntityRepository;

    public InventoryEntityService(KafkaTemplate<String, Object> kafkaTemplate, InventoryEntityRepository inventoryEntityRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.inventoryEntityRepository = inventoryEntityRepository;
    }

    public InventoryEntity save(InventoryEntity inventoryEntity) {

        InventoryEntity inventory =  inventoryEntityRepository.save(inventoryEntity);
        kafkaTemplate.send(INVENTORY_TOPIC, inventory);

        return inventory;
    }

    public List<InventoryEntity> findAll() {
        return inventoryEntityRepository.findAll();
    }

    public InventoryEntity findById(Long id) {
        return inventoryEntityRepository.findById(id).orElseThrow(null);
    }

    public void deleteById(Long id) {
        inventoryEntityRepository.deleteById(id);
    }
}
