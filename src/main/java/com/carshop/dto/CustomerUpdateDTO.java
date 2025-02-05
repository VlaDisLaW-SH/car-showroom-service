package com.carshop.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Setter
@Getter
public class CustomerUpdateDTO {
    @Size(max = 250)
    private JsonNullable<String> fullName;

    @Pattern(regexp = "^\\+7\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$", message = "Допустимый формат номера +7(XXX)XXX-XX-XX")
    private JsonNullable<String> phoneNumber;

    @Column(unique = true)
    @Email
    private JsonNullable<String> email;
}
