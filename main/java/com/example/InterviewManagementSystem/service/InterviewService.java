package com.example.InterviewManagementSystem.service;

import com.example.InterviewManagementSystem.model.Applications;
import com.example.InterviewManagementSystem.model.InterviewStatus;
import com.example.InterviewManagementSystem.model.Interviews;
import com.example.InterviewManagementSystem.model.Users;
import com.example.InterviewManagementSystem.repository.ApplicationRepo;
import com.example.InterviewManagementSystem.repository.InterviewRepo;
import com.example.InterviewManagementSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepo repo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ApplicationRepo appRepo;

    public void scheduleInterview(Interviews interview) {
        Users panel=userRepo.findById(interview.getPanel().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Applications app=appRepo.findById(interview.getApplications().getId())
                .orElseThrow(() -> new RuntimeException("Application not found"));

        interview.setPanel(panel);

        interview.setApplications(app);

        repo.save(interview);
    }

    public List<Interviews> getAll() {
        return repo.findAll();
    }

    public void cancelInterview(Integer id) {
        Interviews interview=repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));;
        interview.setStatus(InterviewStatus.CANCELLED);
    }


    public List<Interviews> getMyInterviews(String email) {
        Users user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return repo.findByApplications_Candidate_IdOrPanel_Id(
                user.getId(),
                user.getId()
        );    }
}
