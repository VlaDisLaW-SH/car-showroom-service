package com.carshop.customers_api.mapper;

import com.carshop.customers_api.dto.CustomerCreateDTO;
import com.carshop.customers_api.dto.CustomerDTO;
import com.carshop.customers_api.dto.CustomerUpdateDTO;
import com.carshop.technical.mapper.JsonNullableMapper;
import com.carshop.customers_api.model.Customer;
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
