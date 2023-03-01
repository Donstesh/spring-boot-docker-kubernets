package com.example.ErrorHandling.controller;

import com.example.ErrorHandling.entity.Users;
import com.example.ErrorHandling.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<Users> findAllUser(){
        return userService.findAllUser();
    }
    @GetMapping("/{id}")
    public Optional<Users> findUserById(@PathVariable("id") Long id){
        return userService.findById(id);
    }
    @PostMapping
    public Users saveUSer(@RequestBody Users users){
        return userService.saveUser(users);
    }
    @PutMapping
    public Users updateUSer(@RequestBody Users users){
        return userService.updateUser(users);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }
}
