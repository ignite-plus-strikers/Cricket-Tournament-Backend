package com.tgt.strikers.service;

import com.tgt.strikers.exception.ScorerFixtureNotFoundException;
import com.tgt.strikers.repository.ScorerFixtureRepository;
import com.tgt.strikers.model.ScorerFixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScorerFixtureService {

    @Autowired
    private ScorerFixtureRepository scorerFixtureRepo;

    //-------------------------------------------------Create New ScorerFixture-------------------------------------------------
    public ScorerFixture createScorerFixture(ScorerFixture scorerFixture) {

        return scorerFixtureRepo.save(scorerFixture);
    }


    //-------------------------------------------------Get All ScorerFixtures---------------------------------------------------
    public List<ScorerFixture> getAllScorerFixture() {

        return scorerFixtureRepo.findAll();
    }

    //-----------------------------------------------Get ScorerFixture By ID ---------------------------------------------------
    public ScorerFixture getScorerFixtureById(String id) {

        Optional<ScorerFixture> optionalScorerFixture = scorerFixtureRepo.findById(id);
        if (!optionalScorerFixture.isPresent())
            throw new ScorerFixtureNotFoundException("ScorerFixture Record with id " + id + " is not available");
        return scorerFixtureRepo.findById(id).get();
    }

    //-----------------------------------------------Update ScorerFixture By ID ------------------------------------------------
    public ScorerFixture updateScorerFixtureById(String id, ScorerFixture scorerFixture) {

        Optional<ScorerFixture> optionalScorerFixture = scorerFixtureRepo.findById(id);
        if (!optionalScorerFixture.isPresent())
            throw new ScorerFixtureNotFoundException("ScorerFixture Record with id " + id + " is not available");
        scorerFixture.setScorerId(id);
        return scorerFixtureRepo.save(scorerFixture);
    }

    //-------------------------------------------------Delete ScorerFixture By ID ----------------------------------------------
    public void deleteScorerFixtureById(String id) {

        Optional<ScorerFixture> optionalScorerFixture = scorerFixtureRepo.findById(id);
        if (!optionalScorerFixture.isPresent())
            throw new ScorerFixtureNotFoundException("ScorerFixture Record with id " + id + " is not available");
        scorerFixtureRepo.deleteById(id);
    }

}
