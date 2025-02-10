package com.carshop.mapper;

import com.carshop.dto.OrderCreateDto;
import com.carshop.dto.OrderDto;
import com.carshop.dto.VehicleForOrderDTO;
import com.carshop.exception.ResourceNotFoundException;
import com.carshop.model.Customer;
import com.carshop.model.Order;
import com.carshop.model.Vehicle;
import com.carshop.repository.CustomerRepository;
import com.carshop.repository.VehicleRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(
        uses = { JsonNullableMapper.class, VehicleMapper.class, CustomerMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class OrderMapper {

    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Mapping(target = "customer", source = "customerId")
    @Mapping(target = "vehicles", source = "vehiclesId")
    public abstract Order map(OrderCreateDto dto);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "vehiclesList", source = "vehicles")
    @Mapping(target = "customerFullName", source = "customer.fullName")
    @Mapping(target = "customerPhoneNumber", source = "customer.phoneNumber")
    public abstract OrderDto map(Order model);
    //public abstract void update(VehicleUpdateDTO dto, @MappingTarget Vehicle model);

    public List<VehicleForOrderDTO> toVehiclesList(List<Vehicle> vehicles) {
        return vehicles.stream()
                .map(vehicle -> vehicleMapper.mapToList(vehicle))
                .collect(Collectors.toList());
    }

    public List<Vehicle> mapToVehicles(List<Long> vehicleIds) {
        return vehicleIds.stream()
                .map(id -> vehicleRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for id: " + id)))
                .toList();
    }

    public Customer mapToCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for id: " + customerId));
    }
}
