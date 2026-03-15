package com.example.InterviewManagementSystem.service;

import com.example.InterviewManagementSystem.model.Role;
import com.example.InterviewManagementSystem.model.Users;
import com.example.InterviewManagementSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public String verify(Users user){
        return "Success";
    }

    public void register(Users user) {
        repo.save(user);
    }

    public List<Users> getAlluser() {
        return repo.findAll();
    }
}
