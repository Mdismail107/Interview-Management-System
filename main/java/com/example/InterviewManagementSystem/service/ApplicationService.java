package com.example.InterviewManagementSystem.service;

import com.example.InterviewManagementSystem.model.ApplicationStatus;
import com.example.InterviewManagementSystem.model.Applications;
import com.example.InterviewManagementSystem.model.Jobs;
import com.example.InterviewManagementSystem.model.Users;
import com.example.InterviewManagementSystem.repository.ApplicationRepo;
import com.example.InterviewManagementSystem.repository.JobRepository;
import com.example.InterviewManagementSystem.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepo appRepo;

    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private UserRepo userRepo;

    public Applications apply(Integer candidateId, Integer jobId) {

        Users candidate = userRepo.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        Jobs job = jobRepo.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        Applications app = new Applications();
        app.setCandidate(candidate);
        app.setJob(job);

        return appRepo.save(app);  
    }

    public List<Applications> getByIdapps(int jobid) {
        return appRepo.findByJob_Id(jobid);
    }

    public void shortList(int id) {
        Applications app = appRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        app.setStatus(ApplicationStatus.SHORTLISTED);
        appRepo.save(app);
    }

    public List<Applications> getAllapps() {
        return appRepo.findAll();
    }

    public List<Applications> getMyApplications(String email) {
        Users user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return appRepo.findByCandidate_Id(user.getId());
    }

}
