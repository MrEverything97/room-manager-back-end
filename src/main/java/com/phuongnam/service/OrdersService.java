package com.phuongnam.service;

import com.phuongnam.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface OrdersService {
    List<Orders> findAll();
    Optional<Orders> findById(Long id);
    void save(Orders orders);
    void remove(Long id);
}

