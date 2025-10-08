package com.r2e.r2e_backend.service;

import com.r2e.r2e_backend.dto.request.RegisterRequest;
import com.r2e.r2e_backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(RegisterRequest registerRequest);
    Optional<User> findByEmail(String email);
    List<User> findAllUsers();
    User findById(Long id);
    void deleteUser(Long id);
    boolean existsByEmail(String email);
}