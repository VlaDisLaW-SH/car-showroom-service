package com.carshop.service;

import com.carshop.model.Vehicle;
import com.carshop.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle with id " + id + " no found"));
    }

    public Vehicle create(Vehicle vehicleData) {
        vehicleRepository.save(vehicleData);
        return vehicleData;
    }

    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }
}
