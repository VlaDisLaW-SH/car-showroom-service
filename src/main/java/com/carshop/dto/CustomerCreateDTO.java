package com.carshop.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerCreateDTO {

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
}
