package com.kafka.controller;

import com.kafka.entity.InventoryEntity;
import com.kafka.service.InventoryEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryEntityController {

    private final InventoryEntityService inventoryEntityService;

    public InventoryEntityController(InventoryEntityService inventoryEntityService) {
        this.inventoryEntityService = inventoryEntityService;
    }

    @GetMapping("/all")
    public List<InventoryEntity> getAllInventory() {
        return inventoryEntityService.findAll();
    }

    @GetMapping("/{id}")
    public InventoryEntity getInventoryById(@PathVariable Long id) {
        return inventoryEntityService.findById(id);
    }

    @PostMapping
    public InventoryEntity createInventory(@RequestBody InventoryEntity inventory) {
        return inventoryEntityService.save(inventory);
    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable Long id) {
        inventoryEntityService.deleteById(id);
    }
}
