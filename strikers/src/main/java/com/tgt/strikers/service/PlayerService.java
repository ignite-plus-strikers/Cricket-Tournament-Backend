package com.tgt.strikers.service;


import com.tgt.strikers.exception.PlayerNotFoundException;
import com.tgt.strikers.repository.PlayerRepository;
import com.tgt.strikers.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepo;

//    public Long getPlayerCount() {
//        return playerRepo.count();
//    }

    //-------------------------------------------------Create New Player-------------------------------------------------
    public Player createPlayer(Player player) {

        return playerRepo.save(player);
    }


    //-------------------------------------------------Get All Players---------------------------------------------------
    public List<Player> getAllPlayer() {

        return playerRepo.findAll();
    }


    //-----------------------------------------------Get Player By ID ---------------------------------------------------
    public Player getPlayerById(UUID id) {

        Optional<Player> optionalPlayer = playerRepo.findById(id);
        if (!optionalPlayer.isPresent())
            throw new PlayerNotFoundException("Player Record with id " + id + " is not available");
        return playerRepo.findById(id).get();
    }


    //-----------------------------------------------Update Player By ID ------------------------------------------------
    public Player updatePlayerById(UUID id, Player player) {

        Optional<Player> optionalPlayer = playerRepo.findById(id);
        if (!optionalPlayer.isPresent())
            throw new PlayerNotFoundException("Player Record with id " + id + " is not available");
        player.setPlayerId(id);
        return playerRepo.save(player);
    }


    //-------------------------------------------------Delete Player By ID ----------------------------------------------
    public void deletePlayerById(UUID id) {

        Optional<Player> optionalPlayer = playerRepo.findById(id);
        if (!optionalPlayer.isPresent())
            throw new PlayerNotFoundException("Player Record with id " + id + " is not available");
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
