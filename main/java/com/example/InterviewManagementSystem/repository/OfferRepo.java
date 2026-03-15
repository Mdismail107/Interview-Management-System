package com.example.InterviewManagementSystem.repository;

import com.example.InterviewManagementSystem.model.Applications;
import com.example.InterviewManagementSystem.model.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepo extends JpaRepository<Offers,Integer> {
    List<Offers> findByCandidate_Id(int candidateId);

}
