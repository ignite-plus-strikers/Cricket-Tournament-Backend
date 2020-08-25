package com.tgt.strikers.service;

import com.tgt.strikers.exception.RefereeFixtureNotFoundException;
import com.tgt.strikers.model.RefereeFixture;
import com.tgt.strikers.repository.RefereeFixtureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefereeFixtureService {

    @Autowired
    private RefereeFixtureRepository refereeFixtureRepo;

    //-------------------------------------------------Create New RefereeFixture-------------------------------------------------
    public RefereeFixture createRefereeFixture(RefereeFixture refereeFixture) {

        return refereeFixtureRepo.save(refereeFixture);
    }


    //-------------------------------------------------Get All RefereeFixtures---------------------------------------------------
    public List<RefereeFixture> getAllRefereeFixture() {

        return refereeFixtureRepo.findAll();
    }

    //-----------------------------------------------Get RefereeFixture By ID ---------------------------------------------------
    public RefereeFixture getRefereeFixtureById(UUID id) {

        Optional<RefereeFixture> optionalRefereeFixture = refereeFixtureRepo.findById(id);
        if (!optionalRefereeFixture.isPresent())
            throw new RefereeFixtureNotFoundException("RefereeFixture Record with id " + id + " is not available");
        return refereeFixtureRepo.findById(id).get();
    }

    //-----------------------------------------------Update RefereeFixture By ID ------------------------------------------------
    public RefereeFixture updateRefereeFixtureById(UUID id, RefereeFixture refereeFixture) {

        Optional<RefereeFixture> optionalRefereeFixture = refereeFixtureRepo.findById(id);
        if (!optionalRefereeFixture.isPresent())
            throw new RefereeFixtureNotFoundException("RefereeFixture Record with id " + id + " is not available");
        refereeFixture.setRefereeId(id);
        return refereeFixtureRepo.save(refereeFixture);
    }

    //-------------------------------------------------Delete RefereeFixture By ID ----------------------------------------------
    public void deleteRefereeFixtureById(UUID id) {

        Optional<RefereeFixture> optionalRefereeFixture = refereeFixtureRepo.findById(id);
        if (!optionalRefereeFixture.isPresent())
            throw new RefereeFixtureNotFoundException("RefereeFixture Record with id " + id + " is not available");
        refereeFixtureRepo.deleteById(id);
    }


}
