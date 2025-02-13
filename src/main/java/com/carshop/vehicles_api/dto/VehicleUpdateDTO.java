package com.carshop.vehicles_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Setter
@Getter
public class VehicleUpdateDTO {
    @NotBlank
    @Size(max = 100)
    private JsonNullable<String> brand;

    @NotBlank
    @Size(max = 100)
    private JsonNullable<String> model;

    @NotNull
    @Pattern(regexp = "^(19|20)\\d{2}$", message = "Год должен быть в формате YYYY (например, 1999, 2021)")
    private JsonNullable<String> issueYear;

    @NotNull
    private JsonNullable<Integer> price;

    @NotBlank
    @Size(max = 50)
    private JsonNullable<String> status;

    @Size(max = 30)
    private JsonNullable<String> bodyType;

    private JsonNullable<String> description;
}
