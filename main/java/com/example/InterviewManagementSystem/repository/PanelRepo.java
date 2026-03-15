package com.example.InterviewManagementSystem.repository;

import com.example.InterviewManagementSystem.model.PanelAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelRepo extends JpaRepository<PanelAvailability,Integer> {
}
