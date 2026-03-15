package com.example.InterviewManagementSystem.controller;

import com.example.InterviewManagementSystem.model.Users;
import com.example.InterviewManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UserService service;

    @GetMapping("users")
    public List<Users> getAlluser(){
        return service.getAlluser();
    }
}
