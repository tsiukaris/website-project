package com.studying.web.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "name", unique = true)
    private String name;
    private String category;
    private String description;
    private int price;
    private int quantity;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, mappedBy = "product", orphanRemoval = true)
    List<OrderedProduct> orderedProducts;

    public Product(){

    }

    public Product(String name, String category, String description, int price, int quantity) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }


}
