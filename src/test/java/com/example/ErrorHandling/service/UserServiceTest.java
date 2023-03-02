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
    void saveUser() {
        //given
        String userName = "Joy Ruth";
        Users users = new Users(
                1,
                userName,
                "TECH",
                "7627 TZ"
        );
        //when
        userService.saveUser(users);
    }

    @Test
    void updateUser() {
        //given
        String userName = "Joy Ruth";
        Users users = new Users(
                1,
                userName,
                "TECH2",
                "7627 TZ"
        );
        //when
        userService.updateUser(users);
    }

    @Test
    void findById() {
        Long id = 1L;
        //when
        userService.findById(id);
        //then
        verify(usersRepository).findById(id);
    }

    @Test
    void deleteUser() {
        Long id = 1L;

        //when
        userService.deleteUser(id);
        //then
        verify(usersRepository).deleteById(id);

    }
}