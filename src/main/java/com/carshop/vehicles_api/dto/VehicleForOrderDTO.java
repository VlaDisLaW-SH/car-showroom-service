package com.carshop.vehicles_api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VehicleForOrderDTO {
    private Long id;
    private String brand;
    private String model;
    private String issueYear;
    private Integer price;
    private String bodyType;
}
