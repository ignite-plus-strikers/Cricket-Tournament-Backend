package com.tgt.strikers.controller;

import com.tgt.strikers.model.Teams;
import com.tgt.strikers.service.TeamService;
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
@Api(tags = "Team Details")
public class TeamController {

    @Autowired
    private TeamService teamService;

    //-------------------------------------------------Create New Team-------------------------------------------------
    @ApiOperation(value = "Create New Team")
    @PostMapping("/team")
    public Teams createTeam(@Valid @RequestBody Teams teams) {
        teams.setTeamId(UUID.randomUUID());
        return teamService.createTeam(teams);
    }


    //-------------------------------------------------Get All Team---------------------------------------------------
    @ApiOperation(value = "Get All Teams")
    @GetMapping("/teams")
    public List<Teams> getAllTeams() {

        return teamService.getAllTeams();
    }

    //-----------------------------------------------Get Team By ID ---------------------------------------------------
    @ApiOperation(value = "Get Team By Id")
    @GetMapping(value = "/team/{id}")
    public Teams getTeamById(@PathVariable("id") UUID id) {

        return teamService.getTeamById(id);
    }

    //-----------------------------------------------Update Team By ID ------------------------------------------------
    @ApiOperation(value = "Update Team")
    @PutMapping(value = "/team/{id}")
    public Teams updateTeamById(@PathVariable("id") UUID id, @RequestBody Teams teams) {

        return teamService.updateTeamById(id, teams);
    }

    //-------------------------------------------------Delete Team By ID ----------------------------------------------
    @ApiOperation(value = "Delete Team")
    @DeleteMapping(value = "/team/{id}")
    public String deleteTeamById(@PathVariable("id") UUID id) {
        teamService.deleteTeamById(id);
        return "Team with id " + id + " has been deleted!";
    }

}