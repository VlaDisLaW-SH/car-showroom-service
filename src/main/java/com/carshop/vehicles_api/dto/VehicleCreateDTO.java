package com.carshop.vehicles_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VehicleCreateDTO {

    @NotBlank
    @Size(max = 100)
    private String brand;

    @NotBlank
    @Size(max = 100)
    private String model;

    @NotNull
    @Pattern(regexp = "^(19|20)\\d{2}$", message = "Год должен быть в формате YYYY (например, 1999, 2021)")
    private String issueYear;

    @NotNull
    private Integer price;

    @NotBlank
    @Size(max = 50)
    private String status;

    @Size(max = 30)
    private String bodyType;

    private String description;
}
