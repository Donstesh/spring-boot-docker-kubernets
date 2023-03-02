package com.example.ErrorHandling.service;

import com.example.ErrorHandling.entity.Users;
import com.example.ErrorHandling.repository.UsersRepository;
import com.example.ErrorHandling.service.impl.Userserviceimpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class UserServiceTest {
    @Mock
    private UsersRepository usersRepository;
    private AutoCloseable autoCloseable;
    private UserService userService;
    private Users users;
    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        userService = new Userserviceimpl(usersRepository);
    }
    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }
    @Test
    void findAllUser() {
        //when
        userService.findAllUser();
        //then
        verify(usersRepository).findAll();
    }

    @Test
    @Disabled
    void saveUser() {
        //when
        userService.saveUser(new Users());
        //then
        Users Users;
        verify(usersRepository).save(users);
    }

    @Test
    @Disabled
    void updateUser() {
    }

    @Test
    @Disabled
    void findById() {
    }

    @Test
    @Disabled
    void deleteUser() {
    }
}