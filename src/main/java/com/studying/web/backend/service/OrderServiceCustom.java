package com.studying.web.backend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

//Custom repository with custom functionality
public interface OrderServiceCustom {
    public abstract List findByCustomerIdAndLocalDateTime(int id, LocalDateTime localDateTime);
    public abstract String createNewOrder(int id, Map<String, Integer> map);
}
