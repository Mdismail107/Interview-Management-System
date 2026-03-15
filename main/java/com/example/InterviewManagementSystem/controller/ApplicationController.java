package com.example.InterviewManagementSystem.controller;

import com.example.InterviewManagementSystem.model.Applications;
import com.example.InterviewManagementSystem.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("applications")
public class ApplicationController {

    @Autowired
    private ApplicationService service;



    @PostMapping("/apply")
    public Applications apply(@RequestParam Integer candidateId,
                              @RequestParam Integer jobId){
        return service.apply(candidateId, jobId);
    }

    @GetMapping("/job/{jobid}")
    public List<Applications> getById(@PathVariable int jobid){
        return service.getByIdapps(jobid);
    }

    @PutMapping("/{id}/shortlist")
    public void  shortList(@PathVariable int id){
         service.shortList(id);
    }

    @GetMapping("/my")
    public List<Applications> myApplications(Principal principal) {
        return service.getMyApplications(principal.getName());
    }


}
