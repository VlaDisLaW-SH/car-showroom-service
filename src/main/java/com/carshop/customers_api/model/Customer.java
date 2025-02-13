package com.carshop.customers_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "customers")
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 250)
    private String fullName;

    @NotNull
    @Pattern(regexp = "^\\+7\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$", message = "Допустимый формат номера +7(XXX)XXX-XX-XX")
    private String phoneNumber;

    @NotNull
    @Column(unique = true)
    @Email
    private String email;

    @NotNull
    @Size(min = 8)
    private String password;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
