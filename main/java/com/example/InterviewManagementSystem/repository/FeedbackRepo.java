package com.example.InterviewManagementSystem.repository;

import com.example.InterviewManagementSystem.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback,Integer> {
}
