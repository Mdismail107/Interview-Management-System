package com.example.InterviewManagementSystem.service;

import com.example.InterviewManagementSystem.model.Jobs;
import com.example.InterviewManagementSystem.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository repo;

    public List<Jobs> allJobs() {
        return repo.findAll();
    }

    public void postJobs(Jobs job) {
        repo.save(job);
    }

    public Jobs updateJob(int id, Jobs job) {

        Jobs existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        existing.setTitle(job.getTitle());
        existing.setDescription(job.getDescription());
        existing.setStatus(job.getStatus());
        existing.setCreatedBy(job.getCreatedBy());

        return repo.save(existing);
    }

    public void deleteJob(int id) {
        repo.deleteById(id);
    }

    public Jobs getJobByid(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }
}
