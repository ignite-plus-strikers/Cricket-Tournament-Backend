package com.tgt.strikers.service;

import com.tgt.strikers.exception.FixtureNotFoundException;
import com.tgt.strikers.repository.FixtureRepository;
import com.tgt.strikers.model.Fixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class FixtureService {
    @Autowired
    private FixtureRepository fixtureRepository;

    public Fixture createFixture(Fixture fixture){
        return fixtureRepository.save(fixture);
    }

    public List<Fixture> getFixtures(){
        return fixtureRepository.findAll();
    }

    public String deleteFixtureById(UUID fixtureId){
        Optional<Fixture> optionalFixture = fixtureRepository.findById(fixtureId);
        if(!optionalFixture.isPresent())
            throw new FixtureNotFoundException("Fixture specified is invalid!");
        fixtureRepository.deleteById(fixtureId);
        return "Fixture deleted!";
    }

    public Fixture getFixtureById(UUID fixtureId){
        Optional<Fixture> optionalFixture = fixtureRepository.findById(fixtureId);
        if(!optionalFixture.isPresent())
            throw new FixtureNotFoundException("Fixture specified is invalid!");
        return fixtureRepository.findById(fixtureId).get();
    }


    public Fixture updateFixtureById(UUID fixtureId,Fixture fixture){
        Optional<Fixture> optionalFixture = fixtureRepository.findById(fixtureId);
        if(!optionalFixture.isPresent())
            throw new FixtureNotFoundException("Fixture id "+fixtureId+" is invalid!");
        return fixtureRepository.save(fixture);
    }
}
