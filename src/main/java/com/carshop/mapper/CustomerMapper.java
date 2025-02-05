package com.carshop.mapper;

import com.carshop.dto.CustomerCreateDTO;
import com.carshop.dto.CustomerDTO;
import com.carshop.dto.CustomerUpdateDTO;
import com.carshop.model.Customer;
import org.mapstruct.*;

@Mapper(
        uses = { JsonNullableMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class CustomerMapper {
    public abstract Customer map(CustomerCreateDTO dto);
    public abstract CustomerDTO map(Customer model);
    public abstract void update(CustomerUpdateDTO dto, @MappingTarget Customer model);
}
