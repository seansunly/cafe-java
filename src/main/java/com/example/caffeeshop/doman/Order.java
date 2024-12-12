package com.example.caffeeshop.doman;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codeOrder;
    private String description;
    private Float subTotal;
    private Float itemDiscount;
    private Float shippingCost;
    private Float total;
    private String promo;
    private Float discount;
    private Float greteTotal;
    private Integer quantity;
    private String city;
    private String province;
    private String country;
    private Date createAt;
    private Date updateAt;
    private String content;

    @ManyToMany
    @JoinTable(name = "Order_product",
            joinColumns = @JoinColumn(name = "order_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id"))
    private List<Product> products;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order")
    private List<Transaction> transactions;


}
