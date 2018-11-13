package com.studying.web.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "order_t")
public class Orders {

    @Id
    @GeneratedValue
    private int id;

    @CreationTimestamp
    @Column(name = "ORDER_DATE")
    private LocalDateTime localDateTime;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    Customer customer;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders", orphanRemoval = true)
    List<OrderedProduct> orderedProductList;

    public Orders(){
    }

}
