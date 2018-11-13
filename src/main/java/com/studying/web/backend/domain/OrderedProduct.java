package com.studying.web.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class OrderedProduct {

    @Id
    @GeneratedValue
    private int id;

    private int quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Orders orders;


    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    Product product;

    public OrderedProduct(){
    }

    public OrderedProduct(int quantity){
        this.quantity = quantity;
    }
}
