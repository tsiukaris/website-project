package com.studying.web.backend.service;

import com.studying.web.backend.dto.Customer;
import com.studying.web.backend.dto.OrderedProduct;
import com.studying.web.backend.dto.Orders;
import com.studying.web.backend.dto.Product;
import com.studying.web.backend.repository.CustomerRepository;
import com.studying.web.backend.repository.ProductRepository;
import com.studying.web.backend.util.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class OrderServiceCustomImpl implements OrderServiceCustom {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;


//    can add an injection with other name of persistence unit if several data sources presented
//    @PersistenceContext(unitName = "1")
//    EntityManager entityManager;

    /*Otherwise I would need to create EntityManager
    for each method manually using EMFactory from JpaUtil*/

    @Override
    public List<Orders> findByCustomerIdAndLocalDateTime(int id, LocalDateTime localDateTime) {
        EntityManager entityManager = JpaUtil.getEmFactory().createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM order_t WHERE customer_id = ? AND order_date = ?");
        query.setParameter(1, id);
        query.setParameter(2, localDateTime);
        return query.getResultList();
    }

    @Override
    public String createNewOrder(int customerid, Map<String, Integer> map) throws NoSuchElementException{

        if(customerRepository.findById(customerid).isPresent()){
            Orders order = new Orders();
            Customer customer = customerRepository.findById(customerid).get();

            order.setCustomer(customer);
            order.setOrderedProductList(fillOrdProdList(order, map));
            List<Orders> ordersList = customer.getOrders();
            ordersList.add(order);
            customer.setOrders(ordersList);
            customerRepository.save(customer);
        } else {
            System.out.println("Customer was not found by ID");
        }

        //redirect to customer's orders page
        return "http://localhost:8080/api/customers/" + customerid + "/orders";
    }


    private List<OrderedProduct> fillOrdProdList(Orders order, Map<String, Integer> map){

        List<OrderedProduct> ordProdList = new ArrayList<>();
        OrderedProduct[] orderedProducts = new OrderedProduct[map.size()];

        Product product;
        int productId = 0;
        int j = 0;

        try{
            for(Map.Entry<String, Integer> entry: map.entrySet()){
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
            System.out.println("Product not found by product id" + productId);
        }
        return ordProdList;
    }

}
