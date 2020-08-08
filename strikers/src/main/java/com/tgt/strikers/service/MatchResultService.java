package com.tgt.strikers.service;

import com.tgt.strikers.exception.MatchResultNotFoundException;
import com.tgt.strikers.model.MatchResult;
import com.tgt.strikers.repository.MatchResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MatchResultService {

    @Autowired
    private MatchResultRepository matchResultRepo;

    //-------------------------------------------------Create New MatchResult-------------------------------------------------
    public MatchResult createMatchResult(MatchResult matchResult) {

        return matchResultRepo.save(matchResult);
    }


    //-------------------------------------------------Get All MatchResult---------------------------------------------------
    public List<MatchResult> getAllMatchResult() {

        return matchResultRepo.findAll();
    }


    //-----------------------------------------------Get MatchResult By ID ---------------------------------------------------
    public MatchResult getMatchResultById(UUID id) {

        Optional<MatchResult> optionalMatchResult = matchResultRepo.findById(id);
        if (!optionalMatchResult.isPresent())
            throw new MatchResultNotFoundException("Match Result Record with id " + id + " is not available");
        return matchResultRepo.findById(id).get();
    }


    //-----------------------------------------------Update MatchResult By ID ------------------------------------------------
    public MatchResult updateMatchResultById(UUID id, MatchResult matchResult) {

        Optional<MatchResult> optionalMatchResult = matchResultRepo.findById(id);
        if (!optionalMatchResult.isPresent())
            throw new MatchResultNotFoundException("Match Result Record with id " + id + " is not available");
        matchResult.setMatchId(id);
        return matchResultRepo.save(matchResult);
    }


//-------------------------------------------------Delete MatchResult By ID ----------------------------------------------
/*    public void deleteMatchResultById(UUID id) {

        Optional<MatchResult> optionalMatchResult = matchResultRepo.findById(id);
        if (!optionalMatchResult.isPresent())
            throw new MatchResultNotFoundException("MatchResult Record with id " + id + " is not available");
        matchResultRepo.deleteById(id);
    }*/
}