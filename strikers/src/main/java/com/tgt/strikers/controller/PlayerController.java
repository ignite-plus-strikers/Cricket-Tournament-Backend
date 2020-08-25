package com.tgt.strikers.controller;

import com.tgt.strikers.model.Player;
import com.tgt.strikers.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
@Api(tags = "Player Details")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

/*
    @GetMapping("/player-count")
    public Long getPlayerCount() {

        return playerService.getPlayerCount();
    }
*/

    //-------------------------------------------------Create New Player-------------------------------------------------
    @ApiOperation(value = "Create New Player")
    @PostMapping("/player")
    public Player createPlayer(@Valid @RequestBody Player player) {
        player.setPlayerId(UUID.randomUUID());

        return playerService.createPlayer(player);
    }


    //-------------------------------------------------Get All Player---------------------------------------------------
    @ApiOperation(value = "Get All Players")
    @GetMapping("/players")
    public List<Player> getAllPlayer() {

        return playerService.getAllPlayer();
    }

    //-----------------------------------------------Get Player By ID ---------------------------------------------------
    @ApiOperation(value = "Get Player By Id")
    @GetMapping(value = "/player/{id}")
    public Player getPlayerById(@PathVariable("id") UUID id) {

        return playerService.getPlayerById(id);
    }

    //-----------------------------------------------Update Player By ID ------------------------------------------------
    @ApiOperation(value = "Update Player")
    @PutMapping(value = "/player/{id}")
    public Player updatePlayerById(@PathVariable("id") UUID id, @RequestBody Player player) {

        return playerService.updatePlayerById(id, player);
    }

    //-------------------------------------------------Delete Player By ID ----------------------------------------------
    @ApiOperation(value = "Delete Player")
    @DeleteMapping(value = "/player/{id}")
    public String deletePlayerById(@PathVariable("id") UUID id) {

        playerService.deletePlayerById(id);
        return "Player with id " + id + " has been deleted!";
    }


}
