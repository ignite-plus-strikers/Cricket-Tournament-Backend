package com.tgt.strikers.controller;

import com.tgt.strikers.model.ScorerCred;
import com.tgt.strikers.service.ScorerCredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class ScorerCredController {

    @Autowired
    private ScorerCredService scorerCredService;

    @PostMapping("/scorer-cred")
    public String createScorerCred(@RequestBody ScorerCred scorer) {
        return scorerCredService.createScorerCred(scorer);
    }

    @GetMapping("/scorer-creds")
    public List<ScorerCred> getAllScorerCred() {
        return scorerCredService.getAllScorerCred();
    }
}