package com.example.ErrorHandling.service.impl;

import com.example.ErrorHandling.entity.Users;
import com.example.ErrorHandling.repository.UsersRepository;
import com.example.ErrorHandling.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Userserviceimpl implements UserService {

    private final UsersRepository usersRepository;

    public Userserviceimpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> findAllUser() {
        return usersRepository.findAll();
    }

    @Override
    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public Users updateUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}
