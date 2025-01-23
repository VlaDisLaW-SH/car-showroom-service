package com.carshop.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Setter
@Getter
public class VehicleUpdateDTO {
    private JsonNullable<String> brand;
    private JsonNullable<String> model;
    private JsonNullable<String> issueYear;
    private JsonNullable<Integer> price;

    @NotNull
    private JsonNullable<String> status;
    private JsonNullable<String> bodyType;
    private JsonNullable<String> description;
}
