package com.phuongnam.service;
import com.phuongnam.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
    void save(User user);
    void remove(Long id);
    void changePassword(User user, String oldPassword, String newPassword);
}

