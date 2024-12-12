package com.example.caffeeshop.doman;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String codeUser;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    @Column(unique = true,length = 15)
    private String mobilePhone;
    @Column(unique = true,length = 25,nullable = false)
    private String email;
    @Column(length = 20)
    private String password;
    private String confirmPassword;
    @Column(columnDefinition = "TEXT")
    private String profilePicture;
    @Column(columnDefinition = "TEXT")
    private String intro;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;
}
