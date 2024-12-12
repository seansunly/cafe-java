package com.example.caffeeshop.doman;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cartName;
    private String cartAddress;
    private String createAt;
    private String updateAt;
    private String category;
    //private Integer userId;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;
}
