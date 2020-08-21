package com.phuongnam.service;

import com.phuongnam.model.Orders;
import com.phuongnam.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface RoomService {
    List<Room> findAll();
    Optional<Room> findById(Long id);
    void save(Room room);
    void remove(Long id);
}
