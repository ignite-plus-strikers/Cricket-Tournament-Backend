package com.tgt.strikers.service;

import com.tgt.strikers.exception.InactiveTeamNotFoundException;
import com.tgt.strikers.model.InactiveTeam;
import com.tgt.strikers.repository.InactiveTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InactiveTeamService {

    @Autowired
    private InactiveTeamRepository inactiveTeamRepo;

    //-------------------------------------------------Create New Inactive Team-------------------------------------------------
    public InactiveTeam createInactiveTeam(InactiveTeam inactiveTeam) {

        return inactiveTeamRepo.save(inactiveTeam);
    }


    //-------------------------------------------------Get All inactive Teams---------------------------------------------------
    public List<InactiveTeam> getAllInactiveTeam() {

        return inactiveTeamRepo.findAll();
    }


    //-----------------------------------------------Get InactiveTeam By ID ---------------------------------------------------
    public InactiveTeam getInactiveTeamById(UUID id) {

        Optional<InactiveTeam> optionalInactiveTeam = inactiveTeamRepo.findById(id);
        if (!optionalInactiveTeam.isPresent())
            throw new InactiveTeamNotFoundException("Inactive Team Record with id " + id + " is not available");
        return inactiveTeamRepo.findById(id).get();
    }


    //-----------------------------------------------Update Inactive Team By ID ------------------------------------------------
/*    public InactiveTeam updateInactiveTeamById(UUID id, InactiveTeam inactiveTeam) {

        Optional<InactiveTeam> optionalInactiveTeam = inactiveTeamRepo.findById(id);
        if (!optionalInactiveTeam.isPresent())
            throw new InactiveTeamNotFoundException("Inactive Team Record with id " + id + " is not available");
        inactiveTeam.setTeamId(id);
        return inactiveTeamRepo.save(inactiveTeam);
    }


    //-------------------------------------------------Delete Inactive Team By ID ----------------------------------------------
    public void deleteInactiveTeamById(UUID id) {

        Optional<InactiveTeam> optionalInactivePlayer = inactiveTeamRepo.findById(id);
        if (!optionalInactiveTeam.isPresent())
            throw new InactiveTeamNotFoundException("Inactive Team Record with id " + id + " is not available");
        inactiveTeamRepo.deleteById(id);
    }*/
}