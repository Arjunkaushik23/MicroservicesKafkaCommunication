package com.kafka.repository;

import com.kafka.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {

   List<OrderEntity> findByProductId(Long productId);
   List<OrderEntity> findByUserId(Long userId);
}
