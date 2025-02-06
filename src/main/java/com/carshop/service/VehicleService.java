package com.carshop.service;

import com.carshop.dto.VehicleCreateDTO;
import com.carshop.dto.VehicleDTO;
import com.carshop.dto.VehicleResponseDto;
import com.carshop.dto.VehicleUpdateDTO;
import com.carshop.exception.ResourceNotFoundException;
import com.carshop.mapper.VehicleMapper;
import com.carshop.model.Vehicle;
import com.carshop.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleMapper vehicleMapper;

    public VehicleResponseDto getVehicles(int page, int size, String sort) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by(sort));
        Page<Vehicle> vehiclePage = vehicleRepository.findAll(pageRequest);

        List<VehicleDTO> convertContentPageToDTO = vehiclePage.stream()
                .map(vehicle -> vehicleMapper.map(vehicle))
                .toList();

        return new VehicleResponseDto(convertContentPageToDTO, (int) vehiclePage.getTotalElements(),
                vehiclePage.getTotalPages());
    }

    public VehicleDTO findById(Long id) {
        var vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle with id " + id + " no found"));
        return vehicleMapper.map(vehicle);
    }

    public VehicleDTO create(VehicleCreateDTO vehicleData) {
        var vehicle = vehicleMapper.map(vehicleData);
        vehicleRepository.save(vehicle);
        return vehicleMapper.map(vehicle);
    }

    public VehicleDTO update(VehicleUpdateDTO vehicleDto, Long id) {
        var vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle with id " + id + " no found"));

        vehicleMapper.update(vehicleDto, vehicle);
        vehicleRepository.save(vehicle);
        return vehicleMapper.map(vehicle);
    }

    public void delete(Long id) {
        var vehicle = vehicleRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Vehicle with id " + id + " no found"));
        vehicleRepository.delete(vehicle);
    }
}
