package com.example.InterviewManagementSystem.service;

import com.example.InterviewManagementSystem.model.Jobs;
import com.example.InterviewManagementSystem.model.OfferStatus;
import com.example.InterviewManagementSystem.model.Offers;
import com.example.InterviewManagementSystem.model.Users;
import com.example.InterviewManagementSystem.repository.JobRepository;
import com.example.InterviewManagementSystem.repository.OfferRepo;
import com.example.InterviewManagementSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private OfferRepo offerRepo;

    public void sentOffer(Offers offer) {
        Users candidate = userRepo.findById(offer.getCandidate().getId())
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        Jobs job = jobRepo.findById(offer.getJob().getId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        offer.setStatus(OfferStatus.PENDING);

        offer.setCandidate(candidate);
        offer.setJob(job);
        offerRepo.save(offer);
    }

    public void replyToOffer(Offers offer, Integer id) {
        Offers off=offerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
        off.setStatus(offer.getStatus());
        offerRepo.save(off);
    }

    public List<Offers> getAllOffers(String email) {
        Users user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return offerRepo.findByCandidate_Id(user.getId());



    }
}
