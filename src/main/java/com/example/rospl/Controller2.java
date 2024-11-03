package com.example.rospl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class Controller2 {
    @Autowired
    private Sservice service;

    @GetMapping("/up/{opportunityId}")
    public List<ModelProjection> getAllModels(@PathVariable("opportunityId") String opp) {
        // System.out.println(opp+"dsjf");
        return service.getAllModels(opp);
    }

    @GetMapping("/opp")
    public List<OppModel> getAllModels() {
        return service.getModels();
    }

    @GetMapping("/studinfo")
    public List<OppModel> getAppliOfStud(  HttpSession session) {
        String studid = (String) session.getAttribute("uid");    
        return service.getAppliOfStud(studid);
    }

    
    
}
