package com.example.InterviewManagementSystem.service;

import com.example.InterviewManagementSystem.model.PanelAvailability;
import com.example.InterviewManagementSystem.model.Users;
import com.example.InterviewManagementSystem.repository.PanelRepo;
import com.example.InterviewManagementSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanelService {

    @Autowired
    private PanelRepo repo;

    @Autowired
    private UserRepo userRepo;

    public void add(PanelAvailability panel) {
        Users panelUser = userRepo.findById(panel.getPanel().getId())
                .orElseThrow(() -> new RuntimeException("Panel not found"));

        panel.setPanel(panelUser);

        repo.save(panel);
    }

    public List<PanelAvailability> getAllSlots() {
        return repo.findAll();
    }

    public void deleteSlot(Integer id){
        repo.deleteById(id);
    }
}
