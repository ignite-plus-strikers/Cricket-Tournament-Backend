package com.tgt.strikers.controller;

import com.tgt.strikers.model.Teams;
import com.tgt.strikers.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class TeamController {

    @Autowired
    private TeamService teamService;

    //-------------------------------------------------Create New Team-------------------------------------------------
    @PostMapping("/team")
    public Teams createTeam(@Valid @RequestBody Teams teams) {
        teams.setTeamId(UUID.randomUUID());
        return teamService.createTeam(teams);
    }


    //-------------------------------------------------Get All Team---------------------------------------------------
    @GetMapping("/teams")
    public List<Teams> getAllTeams() {

        return teamService.getAllTeams();
    }

    //-----------------------------------------------Get Team By ID ---------------------------------------------------
    @GetMapping(value = "/team/{id}")
    public Teams getTeamById(@PathVariable("id") UUID id) {

        return teamService.getTeamById(id);
    }

    //-----------------------------------------------Update Team By ID ------------------------------------------------
    @PutMapping(value = "/team/{id}")
    public Teams updateTeamById(@PathVariable("id") UUID id, @RequestBody Teams teams) {

        return teamService.updateTeamById(id, teams);
    }

    //-------------------------------------------------Delete Team By ID ----------------------------------------------
    @DeleteMapping(value = "/team/{id}")
    public String deleteTeamById(@PathVariable("id") UUID id) {
        teamService.deleteTeamById(id);
        return "Team with id " + id + " has been deleted!";
    }

}