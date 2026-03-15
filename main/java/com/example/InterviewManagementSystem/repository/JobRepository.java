package com.example.InterviewManagementSystem.repository;

import com.example.InterviewManagementSystem.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Jobs,Integer> {
}
