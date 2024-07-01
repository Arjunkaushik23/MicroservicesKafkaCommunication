package com.kafka.service;

import com.kafka.entitiy.OrderEntity;
import com.kafka.entitiy.UserEntity;
import com.kafka.repository.UserEntityRepository;
import org.hibernate.query.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityService {

    private final UserEntityRepository userEntityRepository;

    public UserEntityService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public UserEntity save(UserEntity userEntity) {
        return userEntityRepository.save(userEntity);
    }

    public List<UserEntity> findAll() {
        return userEntityRepository.findAll();
    }

    public UserEntity findById(Long id) {
        return userEntityRepository.findById(id).orElseThrow(null);
    }

    public UserEntity findByEmail(String email) {
        return userEntityRepository.findByEmail(email);
    }

    public void deleteById(Long id) {
        userEntityRepository.deleteById(id);
    }

    public void updateOrdersForUser(OrderEntity orderEntity) {
        UserEntity user = userEntityRepository.findById(orderEntity.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        user.getOrders().add(orderEntity);
        userEntityRepository.save(user);
    }

    public List<OrderEntity> getUserOrders(Long userId) {
        UserEntity user = userEntityRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return  user.getOrders();
    }

}
