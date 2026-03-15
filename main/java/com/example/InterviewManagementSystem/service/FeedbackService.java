package com.example.InterviewManagementSystem.service;

import com.example.InterviewManagementSystem.model.Feedback;
import com.example.InterviewManagementSystem.model.Interviews;
import com.example.InterviewManagementSystem.repository.FeedbackRepo;
import com.example.InterviewManagementSystem.repository.InterviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepo repo;

    @Autowired
    private InterviewRepo interviewRepo;

    public void sentFeedback(Feedback feedback) {
        Interviews interview=interviewRepo.findById(feedback.getInterview().getId())
                .orElseThrow(() -> new RuntimeException("Interview not found"));
        feedback.setInterview(interview);
        repo.save(feedback);
    }

    public List<Feedback> getAllFeedback() {
        return repo.findAll();
    }

    public Optional<Feedback> getById(Integer interviewId) {
        return repo.findById(interviewId);
    }
}
