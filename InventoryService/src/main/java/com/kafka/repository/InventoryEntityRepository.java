package com.kafka.repository;

import com.kafka.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryEntityRepository extends JpaRepository<InventoryEntity, Long> {
}
