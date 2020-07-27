package com.tgt.strikers.service;

import com.tgt.strikers.exception.UmpireNotFoundException;
import com.tgt.strikers.model.Umpire;
import com.tgt.strikers.repository.UmpireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UmpireService {

    @Autowired
    private UmpireRepository umpireRepo;

    //-------------------------------------------------Create New Umpire-------------------------------------------------
    public Umpire createUmpire(Umpire umpire) {

        return umpireRepo.save(umpire);
    }


    //-------------------------------------------------Get All Umpires---------------------------------------------------
    public List<Umpire> getAllUmpire() {

        return umpireRepo.findAll();
    }


    //-----------------------------------------------Get Umpire By ID ---------------------------------------------------
    public Umpire getUmpireById(UUID id) {

        Optional<Umpire> optionalUmpire = umpireRepo.findById(id);
        if (!optionalUmpire.isPresent())
            throw new UmpireNotFoundException("Umpire Record with id " + id + " is not available!");
        return umpireRepo.findById(id).get();
    }


    //-----------------------------------------------Update Umpire By ID ------------------------------------------------
    public Umpire updateUmpireById(UUID id, Umpire umpire) {

        Optional<Umpire> optionalUmpire = umpireRepo.findById(id);
        if (!optionalUmpire.isPresent())
            throw new UmpireNotFoundException("Umpire Record with id " + id + " is not available!");
        umpire.setUmpireId(id);
        return umpireRepo.save(umpire);
    }


    //-------------------------------------------------Delete Umpire By ID ----------------------------------------------
    public void deleteUmpireById(UUID id) {

        Optional<Umpire> optionalUmpire = umpireRepo.findById(id);
        if (!optionalUmpire.isPresent())
            throw new UmpireNotFoundException("Umpire Record with id " + id + " is not available!");
        umpireRepo.deleteById(id);
    }
}