package com.tgt.strikers.controller;

import com.tgt.strikers.model.InactivePlayer;
import com.tgt.strikers.service.InactivePlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class InactivePlayerController {

    @Autowired
    private InactivePlayerService inactivePlayerService;

    //-------------------------------------------------Create New Inactive Player-------------------------------------------------
    @PostMapping("/inactive-player")
    public InactivePlayer createInactivePlayer(@Valid @RequestBody InactivePlayer inactivePlayer) {

        return inactivePlayerService.createInactivePlayer(inactivePlayer);
    }


    //-------------------------------------------------Get All Inactive Player---------------------------------------------------
    @GetMapping("/inactive-players")
    public List<InactivePlayer> getAllInactivePlayer() {

        return inactivePlayerService.getAllInactivePlayer();
    }

    //-----------------------------------------------Get Inactive Player By ID ---------------------------------------------------
    @GetMapping(value = "/inactive-player/{id}")
    public InactivePlayer getInactivePlayerById(@PathVariable("id") UUID id) {

        return inactivePlayerService.getInactivePlayerById(id);
    }

    //-----------------------------------------------Update Inactive Player By ID ------------------------------------------------
 /*   @PutMapping(value = "/inactive-player/{id}")
    public InactivePlayer updateInactivePlayerById(@PathVariable("id") UUID id, @RequestBody InactivePlayer inactivePlayer) {

        return inactivePlayerService.updateInactivePlayerById(id, inactivePlayer);
    }

    //-------------------------------------------------Delete Inactive Player By ID ----------------------------------------------
    @DeleteMapping(value = "/inactive-player/{id}")
    public String deleteInactivePlayerById(@PathVariable("id") UUID id) {

        inactivePlayerService.deleteInactivePlayerById(id);
        return "Inactive Player with id " + id + " has been deleted!";
    }*/

}
