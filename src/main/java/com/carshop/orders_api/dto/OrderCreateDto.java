package com.carshop.orders_api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class OrderCreateDto {
    @NotNull
    private Long customerId;

    @NotEmpty(message = "The list cannot be empty. Insert least one Vehicle to order")
    private List<Long> vehiclesId = new ArrayList<>();
}
