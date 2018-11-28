package com.studying.web.backend.repository;

import com.studying.web.backend.dto.Orders;
import com.studying.web.backend.service.OrderServiceCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>, OrderServiceCustom {

    List<Orders> findAllByCustomer_Id(int customerid);
}
