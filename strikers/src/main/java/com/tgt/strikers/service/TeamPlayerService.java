package com.tgt.strikers.service;

import com.tgt.strikers.exception.TeamPlayerNotFoundException;
import com.tgt.strikers.repository.TeamPlayerRepository;
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
    public List<TeamPlayer> getTeamPlayerById(UUID id)
    {
        List<TeamPlayer> optionalTeamPlayer = teamplayerRepo.findByTeamId(id);
        if(optionalTeamPlayer.isEmpty())
            throw new TeamPlayerNotFoundException("Team Player Record with " + id + " is not available");
        return teamplayerRepo.findByTeamId(id);
    }

    //------------------------Delete Particular Player From Player_Team Combination By ID ------------------------------

    public void deletePlayersByTeamIdPlayerId(UUID teamId, UUID playerId) {

        List<TeamPlayer> teamPlayers = teamplayerRepo.findByTeamId(teamId);
        for(TeamPlayer tempTeamPlayers : teamPlayers) {
            if(tempTeamPlayers.getPlayerId().equals(playerId))
            {
                teamplayerRepo.delete(tempTeamPlayers);
            }
        }
    }


    //--------------------------------------------Delete teamplayer by id-----------------------------------------------------------
    public void deleteTeamPlayerById(UUID id) {
        Optional<TeamPlayer> optionalTeamPlayer = teamplayerRepo.findById(id);
        if (!optionalTeamPlayer.isPresent())
            throw new TeamPlayerNotFoundException("Team Player Record with id " + id + " is not available");
        teamplayerRepo.deleteById(id);
    }
    //--------------------------------------------Delete teamplayer by name---------------------------------------------------------

}
