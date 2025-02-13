package com.carshop.orders_api.service;

import com.carshop.orders_api.dto.OrderCreateDto;
import com.carshop.orders_api.dto.OrderDto;
import com.carshop.technical.exception.ResourceNotFoundException;
import com.carshop.orders_api.exception.VehicleNotAvailableForOrderException;
import com.carshop.orders_api.mapper.OrderMapper;
import com.carshop.vehicles_api.model.Vehicle;
import com.carshop.orders_api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired // todo заменить на конструктор
    private OrderRepository orderRepository;

    @Autowired // todo заменить на конструктор
    private OrderMapper orderMapper;

    public List<OrderDto> getAll() {
        var orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> orderMapper.map(order))
                .toList();
    }

    public OrderDto findById(Long id) {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id " + id + " no found"));
        return orderMapper.map(order);
    }

    public OrderDto create(OrderCreateDto orderData) {
        var order = orderMapper.map(orderData);

        List<Vehicle> vehicleList = order.getVehicles();

        for (Vehicle vehicle: vehicleList) {
            toCheckAvailabilityVehicle(vehicle);
            vehicle.setOrder(order);
            vehicle.setStatus("Order placed");
        }

        order.setTotalPrice(vehicleList);
        orderRepository.save(order);
        return orderMapper.map(order);
    }

    public void delete(Long id) {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id " + id + " no found"));

        for (Vehicle vehicle: order.getVehicles()) {
            vehicle.setOrder(null);
            vehicle.setStatus("In stock");
        }
        orderRepository.delete(order);
    }

    private static void toCheckAvailabilityVehicle(Vehicle vehicle) {
        if (vehicle.getOrder() != null) {
            throw new VehicleNotAvailableForOrderException("Vehicle with ID " + vehicle.getId() + " is in the status: " +
                    vehicle.getStatus() + "\nID the order: " + vehicle.getOrder().getId());
        }
    }
}
