package com.tgt.strikers.controller;

import com.tgt.strikers.service.TeamPlayerService;

import com.tgt.strikers.model.TeamPlayer;


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
@Api(tags = "Player By Team Details")
public class TeamPlayerController {

    @Autowired
    private TeamPlayerService teamplayerService;

    //-------------------------------------------------Create New Team-------------------------------------------------
    @ApiOperation(value = "Create New Player By Team")
    @PostMapping("/teamplayer")
    public TeamPlayer createTeamPlayer(@Valid @RequestBody TeamPlayer teamplayer){
        return teamplayerService.createTeamPlayer(teamplayer);
    }


    //-------------------------------------------------Get All Team---------------------------------------------------
    @ApiOperation(value = "Get All Scorers By Fixture")
    @GetMapping("/teamplayers")
    public List<TeamPlayer> getAllTeamPlayers() {

        return teamplayerService.getAllTeamPlayer();
    }

    //----------------------------Delete Particular Player From Team Player Combination By ID-----------------------------
    @ApiOperation(value = "Delete Player By Team")
    @DeleteMapping(value = "/teamplayer/{teamid}/{playerid}")
    public String deletePlayerByTeamIdPlayerId(@PathVariable("teamid") UUID teamid, @PathVariable("playerid") UUID playerid) {

        teamplayerService.deletePlayersByTeamIdPlayerId(teamid, playerid);
        return "Team Player Combination with Team Id " + teamid + " and Player Id " + playerid + " has been deleted!";
    }


    //-----------------------------------------------Get Team By ID ---------------------------------------------------
    @ApiOperation(value = "Get Player By Team")
    @GetMapping(value = "/teamplayer/{id}")
    public List<TeamPlayer> getTeamPlayerById(@PathVariable("id") UUID id) {

        return teamplayerService.getTeamPlayerById(id);
    }

    //-------------------------------------------------Delete Team By ID ----------------------------------------------
    @ApiOperation(value = "Delete Team With Players")
    @DeleteMapping(value = "/teamplayer/{id}")
    public String deleteTeamPlayerById(@PathVariable("id") UUID id) {
        teamplayerService.deleteTeamPlayerById(id);
        return "Team Player with id " + id + " has been deleted!";
    }

}