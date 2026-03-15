package com.example.InterviewManagementSystem.repository;

import com.example.InterviewManagementSystem.model.Interviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepo extends JpaRepository<Interviews,Integer> {
    List<Interviews> findByApplications_Candidate_IdOrPanel_Id(Integer candidateId, Integer panelId);

}
