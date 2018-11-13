package com.studying.web.backend.repository;

import com.studying.web.backend.domain.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Integer> {
    public List<OrderedProduct> findAllByOrders_Id(int orderid);
}
