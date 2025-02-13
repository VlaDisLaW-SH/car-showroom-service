package com.carshop.controllers;

import com.carshop.orders_api.dto.OrderCreateDto;
import com.carshop.orders_api.dto.OrderDto;
import com.carshop.technical.exception.CustomValidationException;
import com.carshop.orders_api.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<OrderDto>> index() {
        var orders = orderService.getAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<OrderDto> show(@PathVariable Long id) {
        var order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OrderDto> create(@Valid @RequestBody OrderCreateDto orderData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new CustomValidationException(bindingResult);
        }
        var order = orderService.create(orderData);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(order);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable Long id) {
        orderService.delete(id);
    }
}
