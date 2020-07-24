package com.tgt.strikers.controller;

import com.tgt.strikers.service.SeriesTeamsService;
import com.tgt.strikers.model.SeriesTeams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class SeriesTeamsController {

    @Autowired
    private SeriesTeamsService seriesTeamsService;

    //---------------------------------------Create New Series Team Combination-----------------------------------------
    @PostMapping("/series-teams")
    public SeriesTeams createSeriesTeams(@Valid @RequestBody SeriesTeams seriesTeams) {

        return seriesTeamsService.createSeriesTeams(seriesTeams);
    }


    //----------------------------------------Get All Series Team Combination-------------------------------------------
    @GetMapping("/series-teams")
    public List<SeriesTeams> getAllSeriesTeams() {

        return seriesTeamsService.getAllSeriesTeams();
    }


    //----------------------------------------Get Series Team Combination By ID-----------------------------------------
    @GetMapping(value = "/series-teams/{id}")
    public SeriesTeams getSeriesTeamsById(@PathVariable("id") UUID id) {

        return seriesTeamsService.getSeriesTeamsById(id);
    }


    //-----------------------------------------Update Series Team Combination By ID-------------------------------------
    @PutMapping(value = "/series-teams/{id}")
    public SeriesTeams updateSeriesTeamsById(@PathVariable("id") UUID id, @RequestBody SeriesTeams seriesTeams) {

        return seriesTeamsService.updateSeriesTeamsById(id, seriesTeams);
    }


    //-----------------------------------------Delete Series Team Combination By ID-------------------------------------
    @DeleteMapping(value = "/series-teams/{id}")
    public String deleteSeriesTeamsById(@PathVariable("id") UUID id) {

        seriesTeamsService.deleteSeriesTeamsById(id);
        return "Series Team Combination with series id " + id + " has been deleted!";
    }


    //----------------------------Delete Particular Team From Series Team Combination By ID-----------------------------
    @DeleteMapping(value = "/series-teams/{seriesid}/{teamid}")
    public String deleteTeamBySeriesIdTeamsId(@PathVariable("seriesid") UUID seriesid, @PathVariable("teamid") UUID teamid) {

        seriesTeamsService.deleteTeamsBySeriesIdTeamId(seriesid, teamid);
        return "Series Team Combination with Series Id " + seriesid + "and Team Id " + teamid + " has been deleted!";
    }
}