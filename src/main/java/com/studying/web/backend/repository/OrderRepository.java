package com.studying.web.backend.repository;

import com.studying.web.backend.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

    List<Orders> findAllByCustomer_Id(int customerid);
}
