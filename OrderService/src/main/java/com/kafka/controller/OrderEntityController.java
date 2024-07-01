package com.kafka.controller;

import com.kafka.entity.OrderEntity;
import com.kafka.repository.OrderEntityRepository;
import com.kafka.service.OrderEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderEntityController {

    private final OrderEntityService orderEntityService;

    public OrderEntityController(OrderEntityService orderEntityService) {
        this.orderEntityService = orderEntityService;
    }

    @GetMapping("/all")
    public List<OrderEntity> getAllOrders() {
        return orderEntityService.findAll();
    }

    @GetMapping("/{id}")
    public OrderEntity getOrderById(@PathVariable Long id) {
        return orderEntityService.findById(id);
    }

    @PostMapping
    public OrderEntity createOrder(@RequestBody OrderEntity order) {
        return orderEntityService.save(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderEntityService.delete(id);
    }

    @GetMapping("/user/{id}")
    public List<OrderEntity> getOrdersByUserId(@PathVariable Long id) {
        return orderEntityService.findByUserId(id);
    }

    @GetMapping("/product/{id}")
    public List<OrderEntity> getOrdersByProductId(@PathVariable Long id) {
        return orderEntityService.findByProductId(id);
    }

}
