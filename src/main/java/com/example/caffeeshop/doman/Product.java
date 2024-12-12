package com.example.caffeeshop.doman;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,unique = true)
    private String codeProduct;
    @Column(columnDefinition = "TEXT")
    private String tile;
    @Column(columnDefinition = "TEXT")
    private String metaTile;
    @Column(columnDefinition = "TEXT")
    private String slug;
    @Column(columnDefinition = "TEXT")
    private Float price;
    private Float priceDiscount;
    private Integer quantity;
    private Integer discount;
    private String shop;
    private Date createAt;
    private Date updateAt;
    private Date startDate;
    private Date endDate;
    private String image;
    private String content;
    private Boolean isDeleted;
    private Boolean haveNotInStock;

    @ManyToOne
    private Category category;


    @ManyToMany(mappedBy = "products")
    private List<Order> orderList;


    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItemList;
}
