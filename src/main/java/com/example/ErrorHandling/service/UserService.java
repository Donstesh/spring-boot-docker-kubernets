package com.example.ErrorHandling.service;

import com.example.ErrorHandling.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Users> findAllUser();
    Users saveUser(Users user);
    Users updateUser(Users user);
    Optional<Users> findById(Long id);
    void deleteUser(Long id);
}

