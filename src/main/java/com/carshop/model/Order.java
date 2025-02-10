package com.carshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @NotNull
    private Integer totalPrice;

    @NotEmpty(message = "The list cannot be empty. Insert least one Vehicle to order")
    @OneToMany(mappedBy = "order", cascade = CascadeType.REFRESH) //todo
    private List<Vehicle> vehicles = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void setTotalPrice(List<Vehicle> vehicles) {
        totalPrice = vehicles.stream()
                .map(Vehicle::getPrice)
                .reduce(0, Integer::sum);
    }
}
