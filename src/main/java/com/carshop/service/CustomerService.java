package com.carshop.service;

import com.carshop.dto.CustomerCreateDTO;
import com.carshop.dto.CustomerDTO;
import com.carshop.dto.CustomerResponseDto;
import com.carshop.dto.CustomerUpdateDTO;
import com.carshop.exception.ResourceNotFoundException;
import com.carshop.mapper.CustomerMapper;
import com.carshop.model.Customer;
import com.carshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public CustomerResponseDto getCustomers(int page, int size, String sort) {
        PageRequest pageRequest = PageRequest.of(page -1, size, Sort.by(sort));
        Page<Customer> customerPage = customerRepository.findAll(pageRequest);

        List<CustomerDTO> convertContentPageToDTO = customerPage.stream()
                .map(customer -> customerMapper.map(customer))
                .toList();

        return new CustomerResponseDto(convertContentPageToDTO, (int) customerPage.getTotalElements(),
                customerPage.getTotalPages());
    }

    public CustomerDTO findById(Long id) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " no found"));

        return customerMapper.map(customer);
    }

    public CustomerDTO create(CustomerCreateDTO customerDTO) {
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
