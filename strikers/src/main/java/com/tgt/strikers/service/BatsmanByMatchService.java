package com.tgt.strikers.service;

import com.tgt.strikers.exception.BatsmanByMatchNotFoundException;
import com.tgt.strikers.model.BatsmanByMatch;
import com.tgt.strikers.repository.BatsmanByMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BatsmanByMatchService {

    @Autowired
    private BatsmanByMatchRepository batsmanByMatchRepo;

    //-------------------------------------------------Create New BatsmanByMatch-------------------------------------------------
    public BatsmanByMatch createBatsmanByMatch(BatsmanByMatch batsmanByMatch) {

        return batsmanByMatchRepo.save(batsmanByMatch);
    }


    //-------------------------------------------------Get All BatsmanByMatch---------------------------------------------------
    public List<BatsmanByMatch> getAllBatsmanByMatch() {

        return batsmanByMatchRepo.findAll();
    }


    //-----------------------------------------------Get BatsmanByMatch By ID ---------------------------------------------------
    public List<BatsmanByMatch> getBatsmanByMatchById(UUID id) {

        List<BatsmanByMatch> optionalBatsmanByMatch = batsmanByMatchRepo.findByMatchId(id);
        if (optionalBatsmanByMatch.isEmpty())
            throw new BatsmanByMatchNotFoundException("Batsman By Match Record with id " + id + " is not available");
        return batsmanByMatchRepo.findByMatchId(id);
    }

    //------------------------------------------Update Particular Batsman From Match By ID-----------------------------------------------------
    public BatsmanByMatch updateBatsmanByMatchById(UUID matchId, String batsmanName, BatsmanByMatch batsmanByMatch) {

        List<BatsmanByMatch> optionalBatsmanByMatch = batsmanByMatchRepo.findByMatchId(matchId);
        BatsmanByMatch temp = null;
        if (optionalBatsmanByMatch.isEmpty())
            throw new BatsmanByMatchNotFoundException("Batsman By Match Record with Match Id " + matchId + " is not available");
        for (BatsmanByMatch tempBatsmanByMatch : optionalBatsmanByMatch) {
            if (tempBatsmanByMatch.getBatsmanName().equals(batsmanName)) {
                batsmanByMatch.setMatchId(matchId);
                batsmanByMatch.setBatsmanName(batsmanName);
                temp = batsmanByMatch;
            }
        }
        if(temp == null)
            throw new BatsmanByMatchNotFoundException("Batsman By Match Record with Batsman name " + batsmanName + " is not available");
        return batsmanByMatchRepo.save(temp);
    }


    }