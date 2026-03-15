package com.example.InterviewManagementSystem.controller;

import com.example.InterviewManagementSystem.model.Jobs;
import com.example.InterviewManagementSystem.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping("/jobs")
    public List<Jobs> allJob(){
        return service.allJobs();
    }

    @GetMapping("/jobs/{id}")
    public Jobs getJobByid(@PathVariable int id){
        return service.getJobByid(id);
    }

    @PostMapping("/jobs")
    public void postJobs(@RequestBody Jobs job){
        service.postJobs(job);
    }

    @PutMapping("/jobs/{id}")
    public void updateJob(@PathVariable int id,@RequestBody Jobs job){
        service.updateJob(id,job);
    }

    @DeleteMapping("/jobs")
    public void deleteJob(@PathVariable int id){
        service.deleteJob(id);
    }
}
