package com.tgt.strikers.service;

import com.tgt.strikers.exception.SeriesTeamNotFoundException;
import com.tgt.strikers.repository.SeriesTeamsRepository;
import com.tgt.strikers.model.SeriesTeams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SeriesTeamsService {

    @Autowired
    private SeriesTeamsRepository seriesTeamsRepository;

    //--------------------------------------------Create New Series Team Combination------------------------------------
    public SeriesTeams createSeriesTeams(SeriesTeams seriesTeams) {

        return seriesTeamsRepository.save(seriesTeams);
    }


    //--------------------------------------------Get All Series Team Combination---------------------------------------
    public List<SeriesTeams> getAllSeriesTeams() {

        return seriesTeamsRepository.findAll();
    }


    //------------------------Delete Particular Team From Series Team Combination By ID ------------------------------
    public void deleteTeamsBySeriesIdTeamId(UUID seriesId, UUID teamId) {


        List<SeriesTeams> seriesTeams = seriesTeamsRepository.findBySeriesId(seriesId);
        if (seriesTeams.isEmpty())
            throw new SeriesTeamNotFoundException("Series Teams Combination Record with Series Id " + seriesId + " is not available");
        for(SeriesTeams tempSeriesTeams : seriesTeams) {
            if(tempSeriesTeams.getTeamId().equals(teamId))
            {
                seriesTeamsRepository.delete(tempSeriesTeams);
            }
        }
    }


    //-----------------------------Get Series Team Combination By ID ---------------------------------------------------
    public List<SeriesTeams> getSeriesTeamsById(UUID id) {

        List<SeriesTeams> optionalSeriesTeams = seriesTeamsRepository.findBySeriesId(id);
        if (optionalSeriesTeams.isEmpty())
            throw new SeriesTeamNotFoundException("Series Teams Combination Record with Series Id " + id + " is not available");
        return seriesTeamsRepository.findBySeriesId(id);
    }


    //-------------------------------------------Update Series Team Combination By ID -----------------------------------
    public SeriesTeams updateSeriesTeamsById(UUID id, SeriesTeams seriesTeams) {

        Optional<SeriesTeams> optionalSeriesTeams = seriesTeamsRepository.findById(id);
        if (!optionalSeriesTeams.isPresent())
            throw new SeriesTeamNotFoundException("Series Teams Combination Record with Series Id " + id + " is not available");
        seriesTeams.setSeriesId(id);
        return seriesTeamsRepository.save(seriesTeams);
    }


    //------------------------------------------Delete Series Team Combination By ID ------------------------------------
    public void deleteSeriesTeamsById(UUID id) {

        Optional<SeriesTeams> optionalSeriesTeams = seriesTeamsRepository.findById(id);
        if (!optionalSeriesTeams.isPresent())
            throw new SeriesTeamNotFoundException("Series Team Combination Record with Series Id " + id + " is not available");
        seriesTeamsRepository.deleteById(id);
    }
}