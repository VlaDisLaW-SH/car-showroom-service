package com.carshop.service;

import com.carshop.dto.CustomerCreateDTO;
import com.carshop.dto.CustomerDTO;
import com.carshop.dto.CustomerUpdateDTO;
import com.carshop.exception.ResourceNotFoundException;
import com.carshop.mapper.CustomerMapper;
import com.carshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public List<CustomerDTO> getAll() {
        return customerRepository.findAll().stream()
                .map(customer -> customerMapper.map(customer))
                .toList();
    }

    public CustomerDTO findById(Long id) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " no found"));

        return customerMapper.map(customer);
    }

    public CustomerDTO creat(CustomerCreateDTO customerDTO) {
        var customer = customerMapper.map(customerDTO);
        customerRepository.save(customer);
        return customerMapper.map(customer);
    }

    public CustomerDTO update(CustomerUpdateDTO customerDto, Long id) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " no found"));

        customerMapper.update(customerDto, customer);
        customerRepository.save(customer);
        return customerMapper.map(customer);
    }

    public void delete(Long id) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " no found"));

        customerRepository.delete(customer);
    }
}
