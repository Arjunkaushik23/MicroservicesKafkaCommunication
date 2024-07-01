package com.kafka.service;

import com.kafka.entity.InventoryEntity;
import com.kafka.entity.OrderEntity;
import com.kafka.repository.OrderEntityRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderEntityService {

    private static final String ORDER_TOPIC = "user-orders-topic";

    private final OrderEntityRepository orderEntityRepository;
    private  final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderEntityService(OrderEntityRepository orderEntityRepository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.orderEntityRepository = orderEntityRepository;
        this.kafkaTemplate = kafkaTemplate;
    }


    public List<OrderEntity> findAll() {
        return orderEntityRepository.findAll();
    }

    public OrderEntity findById(Long id) {
        return orderEntityRepository.findById(id).orElse(null);
    }

    public OrderEntity save(OrderEntity orderEntity) {
        OrderEntity order =  orderEntityRepository.save(orderEntity);

        kafkaTemplate.send(ORDER_TOPIC, order);
        return order;
    }

    public void delete(Long id) {
        orderEntityRepository.deleteById(id);
    }

    public List<OrderEntity> findByProductId(Long productId) {
        return orderEntityRepository.findByProductId(productId);
    }

    public List<OrderEntity> findByUserId(Long userId) {
        return orderEntityRepository.findByUserId(userId);
    }

    public void updateOrderWithInventory(InventoryEntity inventory) {
        Optional<OrderEntity> optionalOrder = orderEntityRepository.findById(inventory.getOrderId());
        if (optionalOrder.isPresent()) {
            OrderEntity order = optionalOrder.get();
            order.setInventory(inventory); // Assuming you have a field to store inventory details
            orderEntityRepository.save(order);
        }
    }




//    Company Name - HOCALWIRE LABS PRIVATE LIMITED
//    Address - H 157, Office no. 103, First Floor, Rally Infra , Sector 63, Near Ginger Hotel,
//    Nearest Metro Station - Noida Electronic City, Noida, Uttar Pradesh ,201301.
//    Visiting Days - Monday to Friday (Not availability on National Holiday)
//    Visiting Time -  12 PM to 5 PM
//    Contact No. - 9717003787


}
