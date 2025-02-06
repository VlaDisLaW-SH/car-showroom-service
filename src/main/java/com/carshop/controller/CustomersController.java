package com.carshop.controller;

import com.carshop.dto.CustomerCreateDTO;
import com.carshop.dto.CustomerDTO;
import com.carshop.dto.CustomerResponseDto;
import com.carshop.dto.CustomerUpdateDTO;
import com.carshop.exception.CustomValidationException;
import com.carshop.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerResponseDto> index(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort) {

        CustomerResponseDto customerResponseDto = customerService.getCustomers(page, size, sort);
        return ResponseEntity.ok(customerResponseDto);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerDTO> show(@PathVariable Long id) {
        var customer = customerService.findById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerDTO> create(@Valid @RequestBody CustomerCreateDTO customerData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new CustomValidationException(bindingResult);
        }
        var customer = customerService.create(customerData);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customer);
    }

    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerDTO> update(@Valid @RequestBody CustomerUpdateDTO customerData,
                                              BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            throw new CustomValidationException(bindingResult);
        }
        var customer = customerService.update(customerData, id);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable Long id) {
        customerService.delete(id);
    }
}
