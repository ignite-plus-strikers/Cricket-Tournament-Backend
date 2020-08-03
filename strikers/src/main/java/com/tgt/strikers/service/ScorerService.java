package com.tgt.strikers.service;

import com.tgt.strikers.exception.ScorerNotFoundException;
import com.tgt.strikers.repository.ScorerRepository;
import com.tgt.strikers.model.Scorer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScorerService {

    @Autowired
    private ScorerRepository scorerRepo;

    //-------------------------------------------------Create New Scorer-------------------------------------------------
    public Scorer createScorer(Scorer scorer) {

        return scorerRepo.save(scorer);
    }


    //-------------------------------------------------Get All Scorers---------------------------------------------------
    public List<Scorer> getAllScorer() {

        return scorerRepo.findAll();
    }

    //-----------------------------------------------Get Scorer By ID ---------------------------------------------------
    public Scorer getScorerById(UUID id) {

        Optional<Scorer> optionalScorer = scorerRepo.findById(id);
        if (!optionalScorer.isPresent())
            throw new ScorerNotFoundException("Scorer Record with id " + id + " is not available");
        return scorerRepo.findById(id).get();
    }

    //-----------------------------------------------Update Scorer By ID ------------------------------------------------
    public Scorer updateScorerById(UUID id, Scorer scorer) {

        Optional<Scorer> optionalScorer = scorerRepo.findById(id);
        if (!optionalScorer.isPresent())
            throw new ScorerNotFoundException("Scorer Record with id " + id + " is not available");
        scorer.setScorerId(id);
        return scorerRepo.save(scorer);
    }

    //-------------------------------------------------Delete Scorer By ID ----------------------------------------------
    public void deleteScorerById(UUID id) {

        Optional<Scorer> optionalScorer = scorerRepo.findById(id);
        if (!optionalScorer.isPresent())
            throw new ScorerNotFoundException("Scorer Record with id " + id + " is not available");
        scorerRepo.deleteById(id);
    }

    //-----------------------------------------------Get Scorer By Category ---------------------------------------------------
//    public Scorers getScorerByCategory(String p_category) {
//
//            Scorers optionalScorer = scorerRepo.findByCategory(p_category);
//            if (optionalScorer.getP_category() == null)
//                throw new ScorerNotFoundException("Scorer Record with category " + p_category + " is not available");
//
//            return scorerRepo.findByCategory(p_category);
//
//    }


}
