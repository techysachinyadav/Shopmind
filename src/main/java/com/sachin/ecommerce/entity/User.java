package com.sachin.ecommerce.entity;

import com.sachin.ecommerce.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String pass;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role USER;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
