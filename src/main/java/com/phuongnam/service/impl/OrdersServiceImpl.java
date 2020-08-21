package com.phuongnam.service.impl;

import com.phuongnam.model.Orders;
import com.phuongnam.repository.OrdersRepository;
import com.phuongnam.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;
    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public void save(Orders orders) {
        ordersRepository.save(orders);
    }

    @Override
    public void remove(Long id) {
        ordersRepository.deleteById(id);
    }
}
