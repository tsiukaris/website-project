package com.studying.web.backend.controller;


import com.studying.web.backend.domain.Customer;
import com.studying.web.backend.exception.ResourceNotFoundException;
import com.studying.web.backend.repository.CustomerRepository;
import com.studying.web.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/api/customers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/api/customers/{customerid}")
    public Customer getCustomerById(@PathVariable int customerid){
        Optional<Customer> customer = customerRepository.findById(customerid);

        if(!customer.isPresent()) throw new ResourceNotFoundException("id-" + customerid);

        return customer.get();
    }

    @PostMapping("/api/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @PutMapping("/api/customers/{customerid}")
    public Customer updateCustomer(@PathVariable int customerid,
                                   @Valid @RequestBody Customer customerRequest){
        return customerRepository.findById(customerid).map((Customer customer) -> {
            customer.setFirstname(customerRequest.getFirstname());
            customer.setLastname(customerRequest.getLastname());
            customer.setEmail(customerRequest.getEmail());
            customer.setPassword(customerRequest.getPassword());
            customer.setPhonenumber(customerRequest.getPhonenumber());
            customer.setOrders(orderRepository.findAllByCustomer_Id(customerid));
            return customerRepository.save(customer);
        }).orElseThrow(() -> new ResourceNotFoundException("Customer not found by id" + customerid));
    }

    @DeleteMapping("/api/customers/{customerid}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerid){
        return customerRepository.findById(customerid)
                .map((Customer customer) -> {
                    customerRepository.delete(customer);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Customer not found by id" + customerid));
    }

//    @RequestMapping("/customer/{id}")
//    public Customer getAllCustomers(@PathVariable int id){
//        return CustomerService.getCustomersList(id);
//    }
}
