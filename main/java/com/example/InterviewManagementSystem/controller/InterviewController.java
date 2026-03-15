package com.example.InterviewManagementSystem.controller;

import com.example.InterviewManagementSystem.model.Interviews;
import com.example.InterviewManagementSystem.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("interviews")
public class InterviewController {

    @Autowired
    private InterviewService service;

    @PostMapping("/schedule")
    public void scheduleInterview(@RequestBody Interviews interview){
        service.scheduleInterview(interview);
    }

    @GetMapping("/schedule")
    public List<Interviews> getAllInterviews(){
        return service.getAll();
    }

    @PutMapping("/schedule/{id}/cancel")
    public void cancelInterview(@PathVariable Integer id){
        service.cancelInterview(id);
    }

    @GetMapping("/my")
    public List<Interviews> myApplications(Principal principal) {
        return service.getMyInterviews(principal.getName());
    }
}
