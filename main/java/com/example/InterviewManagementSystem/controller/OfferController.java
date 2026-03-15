package com.example.InterviewManagementSystem.controller;

import com.example.InterviewManagementSystem.model.Offers;
import com.example.InterviewManagementSystem.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("offers")
public class OfferController {

    @Autowired
    private OfferService service;

    @PostMapping("send")
    public void sendOffer(@RequestBody Offers offer){
        service.sentOffer(offer);
    }

    @PutMapping("{id}/respond")
    public void replyToOffer(@RequestBody Offers offer,@PathVariable Integer id){
        service.replyToOffer(offer,id);
    }

    @GetMapping("my")
    public List<Offers> allMyOffer(Principal principal){
        return service.getAllOffers(principal.getName());
    }



}
