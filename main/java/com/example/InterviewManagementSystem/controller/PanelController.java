package com.example.InterviewManagementSystem.controller;

import com.example.InterviewManagementSystem.model.PanelAvailability;
import com.example.InterviewManagementSystem.service.PanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("panel")
@RestController
public class PanelController {

    @Autowired
    private PanelService service;

    @PostMapping("/availability")
    public void addSlot(@RequestBody PanelAvailability panel){
        service.add(panel);
    }

    @GetMapping("/availability")
    public List<PanelAvailability> allStots(){
        return service.getAllSlots();
    }

    @DeleteMapping("/availability/{id}")
    public void deleteSlot(@PathVariable Integer id){
        service.deleteSlot(id);
    }
}
