package com.tgt.strikers.Service;

import com.tgt.strikers.Exception.FixtureNotFoundException;
import com.tgt.strikers.Repository.FixtureRepository;
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

    public String deleteFixtureById(UUID fixture_id){
        Optional<Fixture> optionalFixture = fixtureRepository.findById(fixture_id);
        if(!optionalFixture.isPresent())
            throw new FixtureNotFoundException("Fixture specified is invalid!");
        fixtureRepository.deleteById(fixture_id);
        return "Fixture deleted!";
    }

    public Fixture getFixtureById(UUID fixture_id){
        Optional<Fixture> optionalFixture = fixtureRepository.findById(fixture_id);
        if(!optionalFixture.isPresent())
            throw new FixtureNotFoundException("Fixture specified is invalid!");
        return fixtureRepository.findById(fixture_id).get();
    }


    public Fixture updateFixtureById(UUID fixture_id,Fixture fixture){
        Optional<Fixture> optionalFixture = fixtureRepository.findById(fixture_id);
        if(!optionalFixture.isPresent())
            throw new FixtureNotFoundException("Fixture id "+fixture_id+" is invalid!");
        return fixtureRepository.save(fixture);
    }
}
