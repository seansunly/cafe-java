package com.example.caffeeshop.doman;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String codeTransaction;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String imageQRCode;
    private Integer type;
    private Boolean isDeleted;
    private Date createAt;
    private Date updateAt;
    @Column(columnDefinition = "TEXT")
    private String content;
    private Float getMoneyUsa$;
    private Float moneyPayBack$;
    private Integer getMoneyRile;
    private Integer moneyPayBackRile;

    @ManyToOne
    private User user;

    @ManyToOne
    private Order order;
}
