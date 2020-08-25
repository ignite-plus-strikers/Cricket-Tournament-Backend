package com.tgt.strikers.service;

import com.tgt.strikers.exception.PreMatchNotFoundException;
import com.tgt.strikers.model.PreMatch;
import com.tgt.strikers.repository.PreMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PreMatchService {

    @Autowired
    private PreMatchRepository preMatchRepo;

    //-------------------------------------------------Create New PreMatch-------------------------------------------------
    public PreMatch createPreMatch(PreMatch preMatch) {

        return preMatchRepo.save(preMatch);
    }


    //-------------------------------------------------Get All PreMatchs---------------------------------------------------
    public List<PreMatch> getAllPreMatch() {

        return preMatchRepo.findAll();
    }


    //-----------------------------------------------Get PreMatch By ID ---------------------------------------------------
    public PreMatch getPreMatchById(UUID id) {

        Optional<PreMatch> optionalPreMatch = preMatchRepo.findById(id);
        if (!optionalPreMatch.isPresent())
            throw new PreMatchNotFoundException("PreMatch Record with id " + id + " is not available");
        return preMatchRepo.findById(id).get();
    }

}