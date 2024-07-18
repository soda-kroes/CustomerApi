package com.java.E1.java_api.service;

import com.java.E1.java_api.dto.request.CustomerRequestDTO;
import com.java.E1.java_api.entity.Customer;
import com.java.E1.java_api.exception.NotFoundException;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(CustomerRequestDTO customerRequestDTO) throws Exception;
    Customer getCustomerById(Long id) throws NotFoundException;
    List<Customer> getAllCustomer();
    Customer updateCustomer(Long id, CustomerRequestDTO customerRequestDTO) throws Exception;
    Boolean deleteCustomer(Long id) throws NotFoundException;
}
