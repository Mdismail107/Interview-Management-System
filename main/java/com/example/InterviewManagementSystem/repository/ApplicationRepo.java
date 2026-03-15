package com.example.InterviewManagementSystem.repository;

import com.example.InterviewManagementSystem.model.Applications;
import com.example.InterviewManagementSystem.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepo extends JpaRepository<Applications,Integer> {
    List<Applications> findByJob_Id(int jobId);
    List<Applications> findByCandidate_Id(int candidateId);
}
