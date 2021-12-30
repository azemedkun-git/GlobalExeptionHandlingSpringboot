package com.andy.GlobalExceptionHandling.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "emp")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
