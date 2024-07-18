package com.java.E1.java_api.repository;

import com.java.E1.java_api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> existsByName(String name);
}
