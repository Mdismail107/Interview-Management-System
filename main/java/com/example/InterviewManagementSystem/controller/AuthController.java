package com.example.InterviewManagementSystem.controller;

import com.example.InterviewManagementSystem.model.Users;
import com.example.InterviewManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return service.verify(user);
    }

    @PostMapping("/register")
    public void register(@RequestBody Users user){
        service.register(user);
    }
}
