package com.postgresexample.demo.payload;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerDto {
    private Long id;
    private String name;
    private String email;

}