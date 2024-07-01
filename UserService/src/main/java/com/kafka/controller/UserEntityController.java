package com.kafka.controller;

import com.kafka.entitiy.OrderEntity;
import com.kafka.entitiy.UserEntity;
import com.kafka.service.UserEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserEntityController {

    private final UserEntityService userEntityService;

    public UserEntityController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @GetMapping("/{userId}/orders")
    public List<OrderEntity> getUserOrders(@PathVariable Long userId) {
        return userEntityService.getUserOrders(userId);
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userEntityService.findAll();
    }

    @GetMapping("/email/{email}")
    public UserEntity getUsersByEmail(@PathVariable String email) {
        return userEntityService.findByEmail(email);
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userEntityService.findById(id);
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userEntityService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userEntityService.deleteById(id);
    }

}
