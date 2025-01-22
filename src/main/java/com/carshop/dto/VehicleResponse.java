package com.carshop.dto;

import com.carshop.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class VehicleResponse {
    private List<VehicleDTO> vehicles;
    private int totalElements;
    private int totalPages;
}
