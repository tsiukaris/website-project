package com.studying.web.backend.service;

import com.studying.web.backend.dto.Orders;
import com.studying.web.backend.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

public class OrderServiceCustomImpl implements OrderServiceCustom {

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
}
