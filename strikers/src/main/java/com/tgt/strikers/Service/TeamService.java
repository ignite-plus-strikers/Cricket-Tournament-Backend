package com.tgt.strikers.service;

import com.tgt.strikers.exception.PlayerNotFoundException;
import com.tgt.strikers.exception.TeamNotFoundException;
import com.tgt.strikers.model.Player;
import com.tgt.strikers.model.Teams;
import com.tgt.strikers.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service
public class TeamService {

    private TeamRepository teamRepo;
    //--------------------------------------------Create new Team-------------------------------------------------------------

    public Teams createTeam(Teams team)
    {
        return teamRepo.save(team);
    }
    //--------------------------------------------Get all teams---------------------------------------------------------------

    public List<Teams> getAllTeams()
    {
        return teamRepo.findAll();
    }
    //--------------------------------------------Get team by id--------------------------------------------------------------
    public Teams getTeamById(UUID id)
    {
        Optional<Teams> optionalTeam = teamRepo.findById(id);
        if(!optionalTeam.isPresent())
            throw new TeamNotFoundException("Team Record with " + id + "is not available");
        return teamRepo.findById(id).get();
    }

    //--------------------------------------------Get team by name------------------------------------------------------------
    /*public Teams getTeamByName(String tName,UUID id)
    {
        Optional<Teams> optionalTeam = teamRepo.findById(id).getTeamByName(tName);

    }*/
    //--------------------------------------------Update team by id-----------------------------------------------------------
    public Teams updateTeamById(UUID id,Teams teams)
    {
        Optional<Teams> optionalTeam = teamRepo.findById(id);
        if (!optionalTeam.isPresent())
            throw new TeamNotFoundException("Team Record with id " + id + " is not available");
        teams.setTeamId(id);
        return teamRepo.save(teams);
    }
    //--------------------------------------------Update team by name---------------------------------------------------------
    //--------------------------------------------Delete team by id-----------------------------------------------------------
    public void deleteTeamById(UUID id) {
        Optional<Teams> optionalTeam = teamRepo.findById(id);
        if (!optionalTeam.isPresent())
            throw new TeamNotFoundException("Team Record with id " + id + " is not available");
        teamRepo.deleteById(id);
    }
    //--------------------------------------------Delete team by name---------------------------------------------------------
    
}
