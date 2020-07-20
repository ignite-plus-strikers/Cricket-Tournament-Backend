package com.tgt.strikers.Controller;

import com.tgt.strikers.model.Players;
import com.tgt.strikers.Service.PlayerService;
import com.tgt.strikers.Repository.PlayerRepository;
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
    private PlayerRepository playerRepository;

    //-------------------------------------------------Create New Player-------------------------------------------------
    @PostMapping("/player")
    public Players createPlayer(@Valid @RequestBody Players players) {
        players.setPlayerId(UUID.randomUUID());

        return playerService.createPlayer(players);
    }


    //-------------------------------------------------Get All Player---------------------------------------------------
    @GetMapping("/players")
    public List<Players> getAllPlayer() {

        return playerService.getAllPlayer();
    }

    //-----------------------------------------------Get Player By ID ---------------------------------------------------
    @GetMapping(value = "/player/{id}")
    public Players getPlayerById(@PathVariable("id") UUID id) {

        return playerService.getPlayerById(id);
    }

    //-----------------------------------------------Update Player By ID ------------------------------------------------
    @PutMapping(value = "/player/{id}")
    public Players updatePlayerById(@PathVariable("id") UUID id, @RequestBody Players players) {

        return playerService.updatePlayerById(id, players);
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
