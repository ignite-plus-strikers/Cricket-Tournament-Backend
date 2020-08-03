package com.tgt.strikers.controller;


import com.tgt.strikers.model.InactiveTeam;
import com.tgt.strikers.service.InactiveTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class InactiveTeamController {

    @Autowired
    private InactiveTeamService inactiveTeamService;

    //-------------------------------------------------Create New Inactive Team-------------------------------------------------
    @PostMapping("/inactive-team")
    public InactiveTeam createInactivePlayer(@Valid @RequestBody InactiveTeam inactiveTeam) {

        return inactiveTeamService.createInactiveTeam(inactiveTeam);
    }


    //-------------------------------------------------Get All Inactive Team---------------------------------------------------
    @GetMapping("/inactive-teams")
    public List<InactiveTeam> getAllInactiveTeam() {

        return inactiveTeamService.getAllInactiveTeam();
    }

    //-----------------------------------------------Get Inactive Team By ID ---------------------------------------------------
    @GetMapping(value = "/inactive-team/{id}")
    public InactiveTeam getInactiveTeamById(@PathVariable("id") UUID id) {

        return inactiveTeamService.getInactiveTeamById(id);
    }

    //-----------------------------------------------Update Inactive Team By ID ------------------------------------------------
   /* @PutMapping(value = "/inactive-team/{id}")
    public InactiveTeam updateInactiveTeamById(@PathVariable("id") UUID id, @RequestBody InactiveTeam inactiveTeam) {

        return inactiveTeamService.updateInactiveTeamById(id, inactiveTeam);
    }

    //-------------------------------------------------Delete Inactive Team By ID ----------------------------------------------
    @DeleteMapping(value = "/inactive-team/{id}")
    public String deleteInactiveteamById(@PathVariable("id") UUID id) {

        inactiveteamService.deleteInactiveTeamById(id);
        return "Inactive team with id " + id + " has been deleted!";
    }*/

}
