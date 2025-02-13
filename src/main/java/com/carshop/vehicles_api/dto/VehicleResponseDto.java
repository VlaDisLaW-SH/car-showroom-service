package com.carshop.vehicles_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class VehicleResponseDto {
    private List<VehicleDTO> vehicles;
    private int totalElements;
    private int totalPages;
}
