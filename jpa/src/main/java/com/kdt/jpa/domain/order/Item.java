package com.kdt.jpa.domain.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "item")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int price;
    private int stockQuantity;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems;

    public void addOrderItem(OrderItem orderItem) {
        orderItem.setItem(this);
    }
}
