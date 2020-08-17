package com.tgt.strikers.service;

//import com.tgt.strikers.Exception.AdminNotFoundException;
import com.tgt.strikers.model.ScorerCred;
import com.tgt.strikers.repository.ScorerCredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ScorerCredService {

    @Autowired
    private ScorerCredRepository scorerCredRepo;


    public String createScorerCred(ScorerCred scorer) {
        scorerCredRepo.save(scorer);
        return "Scorer " + scorer.getScorerFirstname() + " has been added";
    }

    public List<ScorerCred> getAllScorerCred(){
        return scorerCredRepo.findAll();
    }
}