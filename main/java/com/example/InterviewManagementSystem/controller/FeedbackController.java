package com.example.InterviewManagementSystem.controller;

import com.example.InterviewManagementSystem.model.Feedback;
import com.example.InterviewManagementSystem.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @PostMapping("")
    public void sentFeedback(@RequestBody Feedback feedback){
        service.sentFeedback(feedback);
    }

    @GetMapping("")
    public List<Feedback> getAllFeedback(){
        return service.getAllFeedback();
    }

    @GetMapping("{interviewId}")
    public Optional<Feedback> getById(@PathVariable Integer interviewId){
        return service.getById(interviewId);
    }

}
