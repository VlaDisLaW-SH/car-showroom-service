package com.carshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "vehicles")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @NotBlank
    @Column(length = 100)
    private String brand;

    @NotBlank
    @Column(length = 100)
    private String model;

    @NotNull
    @Pattern(regexp = "^(19|20)\\d{2}$", message = "Год должен быть в формате YYYY (например, 1999, 2021)")
    private String issueYear;

    @NotNull
    private Integer price;

    @NotBlank
    @Column(length = 50)
    private String status;

    @Column(length = 50)
    private String bodyType;

    private String description;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
