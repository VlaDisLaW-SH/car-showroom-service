package com.carshop.service;

import com.carshop.dto.VehicleResponse;
import com.carshop.exception.ResourceNotFoundException;
import com.carshop.model.Vehicle;
import com.carshop.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleResponse getVehicles(int page, int size, String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sort));
        Page<Vehicle> VehiclePage = vehicleRepository.findAll(pageRequest);

        return new VehicleResponse(VehiclePage.getContent(), (int) VehiclePage.getTotalElements(),
                VehiclePage.getTotalPages());
    }

    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle with id " + id + " no found"));
    }

    public Vehicle create(Vehicle vehicleData) {
        vehicleRepository.save(vehicleData);
        return vehicleData;
    }

    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }
}
