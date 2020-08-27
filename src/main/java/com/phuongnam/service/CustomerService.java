package com.phuongnam.service;

import com.phuongnam.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    void save(Customer customer);
    void remove(Long id);
}
