package com.example.caffeeshop.doman;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private Integer codeCartItem;
    private String title;
    private String description;
    private Float price;
    private Float discount;
    private Integer quantity;
    private Boolean active;
    private Date createAt;
    private Date updateAt;
    private String imageUrl;
    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;


    //product
    //cartItem
}
