package com.carshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class CustomerResponseDto {
    private List<CustomerDTO> customers;
    private int totalElements;
    private int totalPages;
}
