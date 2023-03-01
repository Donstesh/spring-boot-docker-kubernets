package com.example.ErrorHandling.controller;

import com.example.ErrorHandling.entity.Users;
import com.example.ErrorHandling.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Consumer {
    @Autowired
    UserService userService;
    @RabbitListener(queues = MQconfig.USER_QUEUE)
    public void Consumer(Users users){
        System.out.println(users);
        this.userService.saveUser(users);
        System.out.println("message saved to db");
        // call vendor
    };
}
