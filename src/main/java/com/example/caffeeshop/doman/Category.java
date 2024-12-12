package com.example.caffeeshop.doman;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "categorys")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String codeCategory;
    @Column(nullable = false,unique = true)
    private String title;

    private String metaTile;
    @Column(nullable = false)
    private String slug;
    @Column(columnDefinition = "TEXT")
    private String text;
    @Column(nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "category")
    private List<Product> products;






}
