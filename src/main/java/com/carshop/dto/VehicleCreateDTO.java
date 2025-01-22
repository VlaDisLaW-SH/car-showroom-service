package com.carshop.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VehicleCreateDTO {
    private String brand;
    private String model;
    private String issueYear;
    private Integer price;
    private String status;
    private String bodyType;
    private String description;
}
