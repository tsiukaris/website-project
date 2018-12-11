package com.studying.web.backend.controller;

import com.studying.web.backend.dto.Customer;
import com.studying.web.backend.dto.OrderedProduct;
import com.studying.web.backend.dto.Orders;
import com.studying.web.backend.dto.Product;
import com.studying.web.backend.repository.CustomerRepository;
import com.studying.web.backend.repository.ProductRepository;
import com.studying.web.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/api/customers/{customerid}/orders")
    public List<Orders> getAllOrdersByCustomerId(@PathVariable int customerid){
        return orderRepository.findAllByCustomer_Id(customerid);
    }

    @GetMapping("/api/orders/{orderid}")
    public Orders getOrderById(@PathVariable int orderid) throws IllegalArgumentException{
        return orderRepository.findById(orderid).get();
    }

    @PostMapping("/api/newOrder/{customerid}")
    public String createNewOrder(@PathVariable int customerid, @RequestBody Map<String, Integer> mapOfProductIdAndQuantity){
        return orderRepository.createNewOrder(customerid, mapOfProductIdAndQuantity);
    }
}
