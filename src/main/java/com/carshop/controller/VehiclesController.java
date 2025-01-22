package com.carshop.controller;

import com.carshop.dto.VehicleCreateDTO;
import com.carshop.dto.VehicleDTO;
import com.carshop.dto.VehicleResponse;
import com.carshop.model.Vehicle;
import com.carshop.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public VehicleResponse index(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort) {
        return vehicleService.getVehicles(page, size, sort);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<VehicleDTO> show(@PathVariable Long id) {
        var vehicles = vehicleService.findById(id);

        return ResponseEntity.ok(vehicles);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VehicleDTO> create(@Valid @RequestBody VehicleCreateDTO vehicleData) {
        var vehicles = vehicleService.create(vehicleData);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vehicles);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable Long id) {
        vehicleService.delete(id);
    }
}
