package com.carshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class VehicleDTO {

    private Long id;
    private String brand;
    private String model;
    private String issueYear;
    private Integer price;
    private String status;
    private String bodyType;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
