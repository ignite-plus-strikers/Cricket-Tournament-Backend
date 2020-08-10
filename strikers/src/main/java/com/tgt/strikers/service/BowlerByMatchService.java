package com.tgt.strikers.service;

import com.tgt.strikers.exception.BowlerByMatchNotFoundException;
import com.tgt.strikers.model.BowlerByMatch;
import com.tgt.strikers.repository.BowlerByMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BowlerByMatchService {

    @Autowired
    private BowlerByMatchRepository bowlerByMatchRepo;

    //-------------------------------------------------Create New BowlerByMatch-------------------------------------------------
    public BowlerByMatch createBowlerByMatch(BowlerByMatch bowlerByMatch) {

        return bowlerByMatchRepo.save(bowlerByMatch);
    }


    //-------------------------------------------------Get All BowlerByMatch---------------------------------------------------
    public List<BowlerByMatch> getAllBowlerByMatch() {

        return bowlerByMatchRepo.findAll();
    }


    //-----------------------------------------------Get BowlerByMatch By ID ---------------------------------------------------
    public List<BowlerByMatch> getBowlerByMatchById(UUID id) {

        List<BowlerByMatch> optionalBowlerByMatch = bowlerByMatchRepo.findByMatchId(id);
        if (optionalBowlerByMatch.isEmpty())
            throw new BowlerByMatchNotFoundException("Bowler By Match Record with id " + id + " is not available");
        return bowlerByMatchRepo.findByMatchId(id);
    }

    //------------------------------------------Update Particular Bowler From Match By ID-----------------------------------------------------
    public BowlerByMatch updateBowlerByMatchById(UUID matchId, String bowlerName, BowlerByMatch bowlerByMatch) {

        List<BowlerByMatch> optionalBowlerByMatch = bowlerByMatchRepo.findByMatchId(matchId);
        BowlerByMatch temp = null;
        if (optionalBowlerByMatch.isEmpty())
            throw new BowlerByMatchNotFoundException("Bowler By Match Record with Match Id " + matchId + " is not available");
        for (BowlerByMatch tempBowlerByMatch : optionalBowlerByMatch) {
            if (tempBowlerByMatch.getBowlerName().equals(bowlerName)) {
                bowlerByMatch.setMatchId(matchId);
                bowlerByMatch.setBowlerName(bowlerName);
                temp = bowlerByMatch;
            }
        }
        if(temp == null)
            throw new BowlerByMatchNotFoundException("Bowler By Match Record with Bowler name " + bowlerName + " is not available");
        return bowlerByMatchRepo.save(temp);
    }

    //--------------------------------------------Get Particular Bowler from Match by ID-----------------------------------------------------------------------

    public BowlerByMatch getBowlerByMatchIdByName(UUID matchId, String bowlerName){

        List<BowlerByMatch> optionalBowlerByMatch = bowlerByMatchRepo.findByMatchId(matchId);
        BowlerByMatch temp = null;
        if(optionalBowlerByMatch.isEmpty())
            throw new BowlerByMatchNotFoundException("Bowler By Match Record with Match Id " + matchId + " is not available");
        for (BowlerByMatch tempBowlerByMatch : optionalBowlerByMatch) {
            if(tempBowlerByMatch.getBowlerName().equals(bowlerName)){
                temp = tempBowlerByMatch;
            }
        }
        if(temp == null){
            throw new BowlerByMatchNotFoundException("Bowler By Match Record with Bowler name " + bowlerName + " is not available");
        }
        return temp;
    }


    //-----------------------------------------------Update BowlerByMatch By ID ------------------------------------------------
/*
    public List<BowlerByMatch> getBowlerByMatchId(UUID id) {

        List<BowlerByMatch> optionalBowlerByMatch = bowlerByMatchRepo.findByBowlerByMatchId(id);
        if (optionalBowlerByMatch.isEmpty())
            throw new BowlerByMatchNotFoundException("Bowler By Match Record with id " + id + " is not available");
        return bowlerByMatchRepo.findByBowlerByMatchId(id);
    }

*/


    //-------------------------------------------------Delete BowlerByMatch By ID ----------------------------------------------
/*    public void deleteBowlerByMatchById(UUID id) {

        Optional<BowlerByMatch> optionalBowlerByMatch = bowlerByMatchRepo.findById(id);
        if (!optionalBowlerByMatch.isPresent())
            throw new BowlerByMatchNotFoundException("BowlerByMatch Record with id " + id + " is not available");
        bowlerByMatchRepo.deleteById(id);
    }*/
}