package com.carshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.carshop.dto.VehicleCreateDTO;
import com.carshop.dto.VehicleDTO;
import com.carshop.model.Vehicle;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class VehicleMapper {
    public abstract Vehicle map(VehicleCreateDTO dto);
    public abstract VehicleDTO map(Vehicle model);
}
