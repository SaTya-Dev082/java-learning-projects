package com.datajpa.learning.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tbl_brands")
public class Brand {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    // @Column(name="name", nullable = false, unique = true,length = 100)
    // private String name;
}
