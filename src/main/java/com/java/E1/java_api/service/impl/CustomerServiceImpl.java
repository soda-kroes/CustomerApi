package com.java.E1.java_api.service.impl;

import com.java.E1.java_api.dto.request.CustomerRequestDTO;
import com.java.E1.java_api.entity.Customer;
import com.java.E1.java_api.exception.AlreadyExistException;
import com.java.E1.java_api.exception.NotFoundException;
import com.java.E1.java_api.repository.CustomerRepository;
import com.java.E1.java_api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(CustomerRequestDTO customerRequestDTO) throws AlreadyExistException {
        Customer customer = new Customer();
        customer.setName(customerRequestDTO.getName());
        customer.setGender(customerRequestDTO.getGender());
        customer.setAddress(customerRequestDTO.getAddress());

        if (customerRepository.existsByName(customerRequestDTO.getName()).isPresent()) {
            throw new AlreadyExistException("Name is not available.");
        }

        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) throws NotFoundException {
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Product with id "+id+" not found."));
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, CustomerRequestDTO customerRequestDTO) throws NotFoundException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer with id " + id + " not found."));

        customer.setName(customerRequestDTO.getName());
        customer.setGender(customerRequestDTO.getGender());
        customer.setAddress(customerRequestDTO.getAddress());
        return customerRepository.save(customer);
    }

    @Override
    public Boolean deleteCustomer(Long id) throws NotFoundException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer with id " + id + " not found."));

        customerRepository.delete(customer);
        return true;
    }
}
