package com.example.cricketapi.controller;

import com.example.cricketapi.model.Players;
import com.example.cricketapi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class PlayerController {

    @Autowired
    private PlayerService playerService;

    //-------------------------------------------------Create New Player-------------------------------------------------
    @PostMapping("/player")
    public Players createPlayer(@Valid @RequestBody Players players) {

        return playerService.createPlayer(players);
    }

    //-------------------------------------------------Get All Players---------------------------------------------------
    @GetMapping("/players")
    public List<Players> getAllPlayers() {

        return playerService.getAllPlayers();
    }

    //-----------------------------------------------Get Player By ID ---------------------------------------------------
    @GetMapping(value = "/player/{id}")
    public Players getPlayerById(@PathVariable("id") int id) {
        return playerService.getPlayerById(id);
    }

    //-----------------------------------------------Update Player By ID ------------------------------------------------
    @PutMapping(value = "/player/{id}")
    public Players updatePlayerById(@PathVariable("id") int id, @RequestBody Players players) {
        return playerService.updatePlayerById(id, players);
    }

    //-------------------------------------------------Delete Player By ID ----------------------------------------------
    @DeleteMapping(value = "/player/{id}")
    public String deletePlayerById(@PathVariable("id") int id) {
        playerService.deletePlayerById(id);
        return "Player with id " + id + " has been deleted!";
    }
}

