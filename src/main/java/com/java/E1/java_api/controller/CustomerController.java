package com.java.E1.java_api.controller;

import com.java.E1.java_api.dto.request.CustomerRequestDTO;
import com.java.E1.java_api.dto.response.StatusResponseDTO;
import com.java.E1.java_api.entity.Customer;
import com.java.E1.java_api.exception.NotFoundException;
import com.java.E1.java_api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<?> create( @RequestBody CustomerRequestDTO customerRequestDTO) throws Exception {
        Map<String, Object> response = new HashMap<>();
        StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
        Customer data = customerService.addCustomer(customerRequestDTO);
        if (data != null) {
            statusResponseDTO.setErrorCode(200);
            statusResponseDTO.setErrorMessage("Customer created successfully");
            response.put("data", data);
        } else {
            statusResponseDTO.setErrorCode(204); // No Content
            statusResponseDTO.setErrorMessage("Your Content Unexceptionable!");
            response.put("data", null);
        }
        response.put("status", statusResponseDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("get-all")
    public ResponseEntity<?> getAllLocations() {
        Map<String,Object> response = new HashMap<>();
        StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
        List<Customer> data = customerService.getAllCustomer();
        if (data.isEmpty()){
            statusResponseDTO.setErrorCode(204);
            statusResponseDTO.setErrorMessage("Customer List is empty");
            response.put("data", null);
        }else{
            statusResponseDTO.setErrorCode(200);
            statusResponseDTO.setErrorMessage("Customer list retrieved successfully");
            response.put("data", data);
        }
        response.put("status", statusResponseDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<?> getBranchById(@PathVariable(name = "id") Long productId) throws NotFoundException {
        Map<String,Object> response = new HashMap<>();
        StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
        Customer data = customerService.getCustomerById(productId);
        if (data==null){
            statusResponseDTO.setErrorCode(204);
            statusResponseDTO.setErrorMessage("Customer is empty");
            response.put("data", null);
        }else{
            statusResponseDTO.setErrorCode(200);
            statusResponseDTO.setErrorMessage("Customer retrieved successfully");
            response.put("data", data);
        }
        response.put("status", statusResponseDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateLoan(@PathVariable(name = "id") Long productId, @RequestBody CustomerRequestDTO customerRequestDTO)throws Exception {
        Map<String, Object> response = new HashMap<>();
        StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
        Customer data = customerService.updateCustomer(productId, customerRequestDTO);
        if (data != null) {
            statusResponseDTO.setErrorCode(200);
            statusResponseDTO.setErrorMessage("Customer updated successfully");
            response.put("data", data);
        }else{
            statusResponseDTO.setErrorCode(204);
            statusResponseDTO.setErrorMessage("Your Content Unexceptionable!");
            response.put("data", null);
        }
        response.put("status", statusResponseDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLoan(@PathVariable(name = "id") Long productId) throws Exception {
        Map<String, Object> response = new HashMap<>();
        StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
        Boolean isDelete = customerService.deleteCustomer(productId);
        if (isDelete) {
            statusResponseDTO.setErrorCode(200);
            statusResponseDTO.setErrorMessage("Customer deleted successfully");
        }
        response.put("status", statusResponseDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
