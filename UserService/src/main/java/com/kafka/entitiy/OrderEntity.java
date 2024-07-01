package com.kafka.entitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    private Long id;
    private Long productId;
    private int quantity;
    private Long UserId;
}
