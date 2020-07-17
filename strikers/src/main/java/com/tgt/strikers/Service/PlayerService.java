package com.tgt.strikers.Service;


import com.tgt.strikers.Exception.PlayerNotFoundException;
import com.tgt.strikers.Repository.PlayerRepository;
import com.tgt.strikers.model.players;
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
    public players createPlayer(players players) {

        return playerRepo.save(players);
    }

    //-------------------------------------------------Get All Players---------------------------------------------------
    public List<players> getAllPlayer() {

        return playerRepo.findAll();
    }

    //-----------------------------------------------Get Player By ID ---------------------------------------------------
    public players getPlayerById(UUID id) {
        Optional<players> optionalPlayer = playerRepo.findById(id);
        if (!optionalPlayer.isPresent())
            throw new PlayerNotFoundException("Player Record with id " + id + " is not available");
        return playerRepo.findById(id).get();
    }

    //-----------------------------------------------Update Player By ID ------------------------------------------------
    public players updatePlayerById(UUID id, players players) {
        Optional<players> optionalPlayer = playerRepo.findById(id);
        if (!optionalPlayer.isPresent())
            throw new PlayerNotFoundException("Player Record with id " + id + " is not available");
        players.setPlayer_id(id);
        return playerRepo.save(players);
    }

    //-------------------------------------------------Delete Player By ID ----------------------------------------------
    public void deletePlayerById(UUID id) {
        Optional<players> optionalPlayer = playerRepo.findById(id);
        if (!optionalPlayer.isPresent())
            throw new PlayerNotFoundException("Palyer Record with id " + id + " is not available");
        playerRepo.deleteById(id);
    }
}
