package com.studying.web.backend.dto;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    private String firstname;
    private String lastname;

    @Column(name = "email", unique = true)
    private String email;
    private String password;
    private String phonenumber;



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
    private List<Orders> orders = new ArrayList<>();

    public Customer(String firstname, String lastname, String email, String password, String phonenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
    }

    public Customer() {
    }

    @Override
    public String toString(){
        return String.format("Customer[id=%d; First Name = %s; Last Name = %s; Email = = %s, Password = %s, Phone Number= %s]",
                id, firstname, lastname, email, password, phonenumber);
    }
}
