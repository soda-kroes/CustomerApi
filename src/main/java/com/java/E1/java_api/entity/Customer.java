package com.java.E1.java_api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "gender",nullable = false)
    private String gender;

    @Column(name = "address",nullable = false)
    private String address;

}
