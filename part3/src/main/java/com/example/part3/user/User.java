package com.example.part3.user;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")

    private Integer id;
    private  String username;
    private  String password;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
