package com.tgt.strikers.service;


import com.tgt.strikers.exception.InactivePlayerNotFoundException;
import com.tgt.strikers.model.InactivePlayer;
import com.tgt.strikers.repository.InactivePlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InactivePlayerService {

    @Autowired
    private InactivePlayerRepository inactivePlayerRepo;

    //-------------------------------------------------Create New Inactive Player-------------------------------------------------
    public InactivePlayer createInactivePlayer(InactivePlayer inactivePlayer) {

        return inactivePlayerRepo.save(inactivePlayer);
    }


    //-------------------------------------------------Get All inactive Players---------------------------------------------------
    public List<InactivePlayer> getAllInactivePlayer() {

        return inactivePlayerRepo.findAll();
    }


    //-----------------------------------------------Get Inactive Player By ID ---------------------------------------------------
    public InactivePlayer getInactivePlayerById(UUID id) {

        Optional<InactivePlayer> optionalInactivePlayer = inactivePlayerRepo.findById(id);
        if (!optionalInactivePlayer.isPresent())
            throw new InactivePlayerNotFoundException("Inactive Player Record with id " + id + " is not available");
        return inactivePlayerRepo.findById(id).get();
    }


    //-----------------------------------------------Update Inactive Player By ID ------------------------------------------------
/*    public InactivePlayer updateInactivePlayerById(UUID id, InactivePlayer inactivePlayer) {

        Optional<InactivePlayer> optionalInactivePlayer = inactivePlayerRepo.findById(id);
        if (!optionalInactivePlayer.isPresent())
            throw new InactivePlayerNotFoundException("Inactive Player Record with id " + id + " is not available");
        inactivePlayer.setPlayerId(id);
        return inactivePlayerRepo.save(inactivePlayer);
    }


    //-------------------------------------------------Delete Inactive Player By ID ----------------------------------------------
    public void deleteInactivePlayerById(UUID id) {

        Optional<InactivePlayer> optionalInactivePlayer = inactivePlayerRepo.findById(id);
        if (!optionalInactivePlayer.isPresent())
            throw new InactivePlayerNotFoundException("Inactive Player Record with id " + id + " is not available");
        inactivePlayerRepo.deleteById(id);
    }*/
}