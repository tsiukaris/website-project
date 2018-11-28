package com.studying.web.backend.repository;

import com.studying.web.backend.dto.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Integer> {
    public List<OrderedProduct> findAllByOrders_Id(int orderid);
}
