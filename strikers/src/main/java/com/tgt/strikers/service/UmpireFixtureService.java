package com.tgt.strikers.service;

import com.tgt.strikers.exception.UmpireFixtureNotFoundException;
import com.tgt.strikers.repository.UmpireFixtureRepository;
import com.tgt.strikers.model.UmpireFixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UmpireFixtureService {

    @Autowired
    private UmpireFixtureRepository umpireFixtureRepo;

    //-------------------------------------------------Create New UmpireFixture-------------------------------------------------
    public UmpireFixture createUmpireFixture(UmpireFixture umpireFixture) {

        return umpireFixtureRepo.save(umpireFixture);
    }


    //-------------------------------------------------Get All UmpireFixtures---------------------------------------------------
    public List<UmpireFixture> getAllUmpireFixture() {

        return umpireFixtureRepo.findAll();
    }

    //-----------------------------------------------Get UmpireFixture By ID ---------------------------------------------------
    public UmpireFixture getUmpireFixtureById(UUID id) {

        Optional<UmpireFixture> optionalUmpireFixture = umpireFixtureRepo.findById(id);
        if (!optionalUmpireFixture.isPresent())
            throw new UmpireFixtureNotFoundException("UmpireFixture Record with id " + id + " is not available");
        return umpireFixtureRepo.findById(id).get();
    }

    //-----------------------------------------------Update UmpireFixture By ID ------------------------------------------------
    public UmpireFixture updateUmpireFixtureById(UUID id, UmpireFixture umpireFixture) {

        Optional<UmpireFixture> optionalUmpireFixture = umpireFixtureRepo.findById(id);
        if (!optionalUmpireFixture.isPresent())
            throw new UmpireFixtureNotFoundException("UmpireFixture Record with id " + id + " is not available");
        umpireFixture.setUmpireId(id);
        return umpireFixtureRepo.save(umpireFixture);
    }

    //-------------------------------------------------Delete UmpireFixture By ID ----------------------------------------------
    public void deleteUmpireFixtureById(UUID id) {

        Optional<UmpireFixture> optionalUmpireFixture = umpireFixtureRepo.findById(id);
        if (!optionalUmpireFixture.isPresent())
            throw new UmpireFixtureNotFoundException("UmpireFixture Record with id " + id + " is not available");
        umpireFixtureRepo.deleteById(id);
    }

    //-----------------------------------------------Get UmpireFixture By Category ---------------------------------------------------
   /*public UmpireFixtures getUmpireFixtureByCategory(String p_category) {

         UmpireFixtures optionalUmpireFixture = umpireFixtureRepo.findByCategory(p_category);
            if (optionalUmpireFixture.getP_category() == null)
                throw new UmpireFixtureNotFoundException("UmpireFixture Record with category " + p_category + " is not available");

            return umpireFixtureRepo.findByCategory(p_category);

   }*/


}
