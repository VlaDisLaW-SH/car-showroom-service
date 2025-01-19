package com.carshop.controller;

import com.carshop.model.Vehicle;
import com.carshop.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Vehicle>> index() {
        var vehicles = vehicleService.getAll();

        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(vehicles.size()))
                .body(vehicles);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Vehicle> show(@PathVariable Long id) {
        var vehicles = vehicleService.findById(id);

        return ResponseEntity.ok()
                .body(vehicles);

    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Vehicle> create(@Valid @RequestBody Vehicle vehicleData) {
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
