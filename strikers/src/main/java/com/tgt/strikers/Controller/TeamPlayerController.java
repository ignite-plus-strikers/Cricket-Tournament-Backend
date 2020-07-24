package com.tgt.strikers.Controller;

import com.tgt.strikers.Service.TeamPlayerService;

import com.tgt.strikers.model.TeamPlayer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class TeamPlayerController {

    @Autowired
    private TeamPlayerService teamplayerService;

    //-------------------------------------------------Create New Team-------------------------------------------------
    @PostMapping("/teamplayer")
    public TeamPlayer createTeamPlayer(@Valid @RequestBody TeamPlayer teamplayer){
        return teamplayerService.createTeamPlayer(teamplayer);
    }


    //-------------------------------------------------Get All Team---------------------------------------------------
    @GetMapping("/teamplayers")
    public List<TeamPlayer> getAllTeamPlayers() {

        return teamplayerService.getAllTeamPlayer();
    }

    //----------------------------Delete Particular Player From Team Player Combination By ID-----------------------------
    @DeleteMapping(value = "/teamplayer/{teamid}/{playerid}")
    public String deletePlayerByTeamIdPlayerId(@PathVariable("teamid") UUID teamid, @PathVariable("playerid") UUID playerid) {

        teamplayerService.deletePlayersByTeamIdPlayerId(teamid, playerid);
        return "Team Player Combination with Team Id " + teamid + " and Player Id " + playerid + " has been deleted!";
    }


    //-----------------------------------------------Get Team By ID ---------------------------------------------------
    /*@GetMapping(value = "/teamplayer/{id}")
    public TeamPlayer getTeamPlayerById(@PathVariable("id") UUID id) {

        return teamplayerService.getTeamplayerId(id);
    }*/

    //-----------------------------------------------Update Team By ID ------------------------------------------------
    /*@PutMapping(value = "/teamplayer/{id}")
    public TeamPlayer updateTeamPlayerById(@PathVariable("id") UUID id, @RequestBody TeamPlayer teamplayer) {

        return teamplayerService.updateTeamPlayerById(id, teamplayer);
    }*/

    //-------------------------------------------------Delete Team By ID ----------------------------------------------
    @DeleteMapping(value = "/teamplayer/{id}")
    public String deleteTeamPlayerById(@PathVariable("id") UUID id) {
        teamplayerService.deleteTeamPlayerById(id);
        return "Team Player with id " + id + " has been deleted!";
    }

}