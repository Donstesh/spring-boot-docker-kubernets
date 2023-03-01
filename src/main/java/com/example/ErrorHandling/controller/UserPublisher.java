package com.example.ErrorHandling.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.example.ErrorHandling.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")

public class UserPublisher {
    @Autowired
    private RabbitTemplate template;
    @PostMapping("save")
    public String publishUser(@RequestBody Users user){

        template.convertAndSend(MQconfig.EXCHANGE, MQconfig.ROUTING_KEY, user);
        return "User Sent to Rabbit MQ!";
    }
}
