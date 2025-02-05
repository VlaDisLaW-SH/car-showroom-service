package com.carshop.controller;

import com.carshop.dto.CustomerCreateDTO;
import com.carshop.dto.CustomerDTO;
import com.carshop.dto.CustomerUpdateDTO;
import com.carshop.exception.CustomValidationException;
import com.carshop.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CustomerDTO>> index() {
        var customers = customerService.getAll();

        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(customers.size()))
                .body(customers);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerDTO> show(@PathVariable Long id) {
        var customer = customerService.findById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerDTO> creat(@Valid @RequestBody CustomerCreateDTO customerData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new CustomValidationException(bindingResult);
        }
        var customer = customerService.creat(customerData);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customer);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerDTO> update(@Valid @RequestBody CustomerUpdateDTO customerData, @PathVariable Long id,
                                              BindingResult bindingResult) {
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
