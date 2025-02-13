package com.carshop.customers_api.service;

import com.carshop.customers_api.dto.CustomerCreateDTO;
import com.carshop.customers_api.dto.CustomerDTO;
import com.carshop.customers_api.dto.CustomerResponseDto;
import com.carshop.customers_api.dto.CustomerUpdateDTO;
import com.carshop.technical.exception.ResourceNotFoundException;
import com.carshop.customers_api.mapper.CustomerMapper;
import com.carshop.customers_api.model.Customer;
import com.carshop.customers_api.repository.CustomerRepository;
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
