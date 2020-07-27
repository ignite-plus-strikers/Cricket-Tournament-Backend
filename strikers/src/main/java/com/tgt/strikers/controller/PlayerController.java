package com.tgt.strikers.controller;

import com.tgt.strikers.model.Player;
import com.tgt.strikers.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    //-------------------------------------------------Create New Player-------------------------------------------------
    @PostMapping("/player")
    public Player createPlayer(@Valid @RequestBody Player player) {
        player.setPlayerId(UUID.randomUUID());

        return playerService.createPlayer(player);
    }


    //-------------------------------------------------Get All Player---------------------------------------------------
    @GetMapping("/players")
    public List<Player> getAllPlayer() {

        return playerService.getAllPlayer();
    }

    //-----------------------------------------------Get Player By ID ---------------------------------------------------
    @GetMapping(value = "/player/{id}")
    public Player getPlayerById(@PathVariable("id") UUID id) {

        return playerService.getPlayerById(id);
    }

    //-----------------------------------------------Update Player By ID ------------------------------------------------
    @PutMapping(value = "/player/{id}")
    public Player updatePlayerById(@PathVariable("id") UUID id, @RequestBody Player player) {

        return playerService.updatePlayerById(id, player);
    }

    //-------------------------------------------------Delete Player By ID ----------------------------------------------
    @DeleteMapping(value = "/player/{id}")
    public String deletePlayerById(@PathVariable("id") UUID id) {

        playerService.deletePlayerById(id);
        return "Player with id " + id + " has been deleted!";
    }




//    @GetMapping(value = "/player/category/{p_category}")
//    public Players getPlayerByCategory(@PathVariable("p_category") String p_category) {
//        return playerService.getPlayerByCategory(p_category);
//    }

}
