package com.studying.web.backend.service;

import java.time.LocalDateTime;
import java.util.List;

//Custom repository with custom functionality
public interface OrderServiceCustom {
    public abstract List findByCustomerIdAndLocalDateTime(int id, LocalDateTime localDateTime);
}
