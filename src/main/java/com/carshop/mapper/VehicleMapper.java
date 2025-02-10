package com.carshop.mapper;

import com.carshop.dto.VehicleForOrderDTO;
import com.carshop.dto.VehicleUpdateDTO;
import org.mapstruct.*;

import com.carshop.dto.VehicleCreateDTO;
import com.carshop.dto.VehicleDTO;
import com.carshop.model.Vehicle;

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
