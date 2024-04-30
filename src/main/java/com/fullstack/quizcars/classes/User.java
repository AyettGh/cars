package com.fullstack.quizcars.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id") // Specify the column name in the database
    private Long id;

    @Column(name = "username") // Specify the column name in the database
    private String username;

    @Column(name = "password") // Specify the column name in the database
    private String password;

    @Column(name = "role") // Specify the column name in the database
    private String role;
}