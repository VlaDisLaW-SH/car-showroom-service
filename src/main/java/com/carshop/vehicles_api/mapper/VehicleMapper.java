package com.carshop.vehicles_api.mapper;

import com.carshop.technical.mapper.JsonNullableMapper;
import com.carshop.vehicles_api.dto.VehicleForOrderDTO;
import com.carshop.vehicles_api.dto.VehicleUpdateDTO;
import org.mapstruct.*;

import com.carshop.vehicles_api.dto.VehicleCreateDTO;
import com.carshop.vehicles_api.dto.VehicleDTO;
import com.carshop.vehicles_api.model.Vehicle;

@Mapper(
        uses = { JsonNullableMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class VehicleMapper {
    public abstract Vehicle map(VehicleCreateDTO dto);
    @Mapping(target = "orderId", source = "order.id")
    public abstract VehicleDTO map(Vehicle model);
    public abstract void update(VehicleUpdateDTO dto, @MappingTarget Vehicle model);
    public abstract VehicleForOrderDTO mapToList(Vehicle model);
}
