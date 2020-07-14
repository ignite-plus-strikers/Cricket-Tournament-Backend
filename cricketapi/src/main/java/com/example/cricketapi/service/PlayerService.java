package com.example.cricketapi.service;


import com.example.cricketapi.dao.PlayerDAO;
import com.example.cricketapi.exceptions.PlayerNotFoundException;
import com.example.cricketapi.model.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerDAO playerDAO;

    //-------------------------------------------------Create New Player-------------------------------------------------
    public Players createPlayer(Players players) {

        return playerDAO.save(players);
    }

    //-------------------------------------------------Get All Playerss---------------------------------------------------
    public List<Players> getAllPlayers() {

        return playerDAO.findAll();
    }

    //-----------------------------------------------Get Player By ID ---------------------------------------------------
    public Players getPlayerById(int id) {
        Optional<Players> optionalPlayer = playerDAO.findById(id);
        if (!optionalPlayer.isPresent())
            throw new PlayerNotFoundException("Player Record with id " + id + " is not available");
        return playerDAO.findById(id).get();
    }

    //-----------------------------------------------Update Player By ID ------------------------------------------------
    public Players updatePlayerById(int id, Players players) {
        Optional<Players> optionalPlayer = playerDAO.findById(id);
        if (!optionalPlayer.isPresent())
            throw new PlayerNotFoundException("Player Record with id " + id + " is not available");
        players.setPlayer_id(id);
        return playerDAO.save(players);
    }

    //-------------------------------------------------Delete Player By ID ----------------------------------------------
    public void deletePlayerById(int id) {
        Optional<Players> optionalPlayer = playerDAO.findById(id);
        if (!optionalPlayer.isPresent())
            throw new PlayerNotFoundException("Palyer Record with id " + id + " is not available");
        playerDAO.deleteById(id);
    }
}

