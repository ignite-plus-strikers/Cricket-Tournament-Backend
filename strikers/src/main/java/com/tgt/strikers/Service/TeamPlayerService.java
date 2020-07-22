package com.tgt.strikers.Service;

import com.tgt.strikers.Exception.TeamPlayerNotFoundException;
import com.tgt.strikers.Repository.TeamPlayerRepository;
import com.tgt.strikers.model.TeamPlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service
public class TeamPlayerService {

    @Autowired
    private TeamPlayerRepository teamplayerRepo;
    //--------------------------------------------Create new Team-------------------------------------------------------------

    public TeamPlayer createTeamPlayer(TeamPlayer teamplayer)
    {
        return teamplayerRepo.save(teamplayer);
    }
    //--------------------------------------------Get all teamplayers---------------------------------------------------------------

    public List<TeamPlayer> getAllTeamPlayer()
    {
        return teamplayerRepo.findAll();
    }
    //--------------------------------------------Get teamplayer by id--------------------------------------------------------------
    public TeamPlayer getTeamPlayerById(UUID id)
    {
        Optional<TeamPlayer> optionalTeamPlayer = teamplayerRepo.findById(id);
        if(!optionalTeamPlayer.isPresent())
            throw new TeamPlayerNotFoundException("Team Player Record with " + id + "is not available");
        return teamplayerRepo.findById(id).get();
    }

    //--------------------------------------------Get teamplayer by name------------------------------------------------------------
    /*public TeamPlayer getTeamByName(String tName,UUID id)
    {
        Optional<TeamPlayer> optionalTeam = teamplayerplayerRepo.findById(id).getTeamByName(tName);

    }*/
    //--------------------------------------------Update teamplayer by id-----------------------------------------------------------
    /*public TeamPlayer updateTeamPlayerById(UUID id,TeamPlayer teamplayers)
    {
        Optional<TeamPlayer> optionalTeamPlayer = teamplayerRepo.findById(id);
        if (!optionalTeamPlayer.isPresent())
            throw new TeamPlayerNotFoundException("Team PLayer Record with id " + id + " is not available");
        teamplayers.setTeamplayerId(id);
        return teamplayerRepo.save(teamplayers);
    }*/
    //--------------------------------------------Update teamplayer by name---------------------------------------------------------
    //--------------------------------------------Delete teamplayer by id-----------------------------------------------------------
    public void deleteTeamPlayerById(UUID id) {
        Optional<TeamPlayer> optionalTeamPlayer = teamplayerRepo.findById(id);
        if (!optionalTeamPlayer.isPresent())
            throw new TeamPlayerNotFoundException("Team Player Record with id " + id + " is not available");
        teamplayerRepo.deleteById(id);
    }
    //--------------------------------------------Delete teamplayer by name---------------------------------------------------------

}
