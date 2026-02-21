package com.SBI.ATM.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="SBI-USERS")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private double balance;
    private String creditCard;
}
