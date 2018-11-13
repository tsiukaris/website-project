package com.studying.web.backend.controller;

import com.studying.web.backend.domain.Customer;
import com.studying.web.backend.domain.OrderedProduct;
import com.studying.web.backend.domain.Orders;
import com.studying.web.backend.domain.Product;
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
    public String createNewOrder(@PathVariable int customerid, @RequestBody Map<String, Integer> mapOfProductIdAndQuantity) throws NoSuchElementException{

        Orders order = new Orders();
        OrderedProduct[] orderedProducts = new OrderedProduct[mapOfProductIdAndQuantity.size()];
        List<OrderedProduct> ordProdList = new ArrayList<>();
        Customer customer;
        Product product;

        int productId = 0;
        customer = customerRepository.findById(customerid).get();
        try{
            int j = 0;
            order.setCustomer(customer);

            for(Map.Entry<String, Integer> entry: mapOfProductIdAndQuantity.entrySet()){
                orderedProducts[j] = new OrderedProduct();
                productId = Integer.parseInt(entry.getKey());
                product = productRepository.findById(productId).get();
                orderedProducts[j].setQuantity(entry.getValue());
                orderedProducts[j].setProduct(product);
                orderedProducts[j].setOrders(order);

                ordProdList.add(orderedProducts[j]);
                j++;
            }
        } catch (NoSuchElementException e){
            System.out.println("Customer or product not found by Id" + customerid + "and product id" + productId);
        }

        order.setOrderedProductList(ordProdList);
        List<Orders> ordersList = customer.getOrders();
        ordersList.add(order);
        customer.setOrders(ordersList);
        customerRepository.save(customer);
        String UrlToCustomerOrders = "http://localhost:8080/api/customers/" + customerid + "/orders";

        return UrlToCustomerOrders;
        /*I know that no order in DB was created yet,
        so I will redirect the client to his orders page*/
    }
}
