package com.tgt.strikers.Service;


import com.tgt.strikers.Exception.PlayerNotFoundException;
import com.tgt.strikers.Repository.PlayerRepository;
import com.tgt.strikers.model.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepo;

    //-------------------------------------------------Create New Player-------------------------------------------------
    public Players createPlayer(Players players) {

        return playerRepo.save(players);
    }


    //-------------------------------------------------Get All Players---------------------------------------------------
    public List<Players> getAllPlayer() {

        return playerRepo.findAll();
    }

    //-----------------------------------------------Get Player By ID ---------------------------------------------------
    public Players getPlayerById(UUID id) {

        Optional<Players> optionalPlayer = playerRepo.findById(id);
        if (!optionalPlayer.isPresent())
            throw new PlayerNotFoundException("Player Record with id " + id + " is not available");
        return playerRepo.findById(id).get();
    }

    //-----------------------------------------------Update Player By ID ------------------------------------------------
    public Players updatePlayerById(UUID id, Players players) {

        Optional<Players> optionalPlayer = playerRepo.findById(id);
        if (!optionalPlayer.isPresent())
            throw new PlayerNotFoundException("Player Record with id " + id + " is not available");
        players.setPlayerId(id);
        return playerRepo.save(players);
    }

    //-------------------------------------------------Delete Player By ID ----------------------------------------------
    public void deletePlayerById(UUID id) {

        Optional<Players> optionalPlayer = playerRepo.findById(id);
        if (!optionalPlayer.isPresent())
            throw new PlayerNotFoundException("Palyer Record with id " + id + " is not available");
        playerRepo.deleteById(id);
    }

    //-----------------------------------------------Get Player By Category ---------------------------------------------------
//    public Players getPlayerByCategory(String p_category) {
//
//            Players optionalPlayer = playerRepo.findByCategory(p_category);
//            if (optionalPlayer.getP_category() == null)
//                throw new PlayerNotFoundException("Player Record with category " + p_category + " is not available");
//
//            return playerRepo.findByCategory(p_category);
//
//    }


}
