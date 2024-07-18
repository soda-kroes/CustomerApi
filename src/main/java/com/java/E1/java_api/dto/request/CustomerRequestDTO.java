package com.java.E1.java_api.dto.request;

import lombok.Data;

@Data
public class CustomerRequestDTO {
    private Long id;
    private String name;
    private String gender;
    private String address;
}
