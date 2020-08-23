package com.tgt.strikers.controller;

import com.tgt.strikers.service.SeriesTeamsService;
import com.tgt.strikers.model.SeriesTeams;
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
@Api(tags = "Series By Team Details")
public class SeriesTeamsController {

    @Autowired
    private SeriesTeamsService seriesTeamsService;

    //---------------------------------------Create New Series Team Combination-----------------------------------------
    @ApiOperation(value = "Create New Series By Team")
    @PostMapping("/series-teams")
    public SeriesTeams createSeriesTeams(@Valid @RequestBody SeriesTeams seriesTeams) {

        return seriesTeamsService.createSeriesTeams(seriesTeams);
    }


    //----------------------------------------Get All Series Team Combination-------------------------------------------
    @ApiOperation(value = "Get All Series By Team")
    @GetMapping("/series-teams")
    public List<SeriesTeams> getAllSeriesTeams() {

        return seriesTeamsService.getAllSeriesTeams();
    }


    //----------------------------------------Get Series Team Combination By ID-----------------------------------------
    @ApiOperation(value = "Get Series By Team By Id")
    @GetMapping(value = "/series-teams/{id}")
    public List<SeriesTeams> getSeriesTeamsById(@PathVariable("id") UUID id) {

        return seriesTeamsService.getSeriesTeamsById(id);
    }


    //-----------------------------------------Update Series Team Combination By ID-------------------------------------
    @ApiOperation(value = "Update Series By Team")
    @PutMapping(value = "/series-teams/{id}")
    public SeriesTeams updateSeriesTeamsById(@PathVariable("id") UUID id, @RequestBody SeriesTeams seriesTeams) {

        return seriesTeamsService.updateSeriesTeamsById(id, seriesTeams);
    }


    //-----------------------------------------Delete Series Team Combination By ID-------------------------------------
    @ApiOperation(value = "Delete Series By Team")
    @DeleteMapping(value = "/series-teams/{id}")
    public String deleteSeriesTeamsById(@PathVariable("id") UUID id) {

        seriesTeamsService.deleteSeriesTeamsById(id);
        return "Series Team Combination with series id " + id + " has been deleted!";
    }


    //----------------------------Delete Particular Team From Series Team Combination By ID-----------------------------
    @ApiOperation(value = "Delete Team From Series")
    @DeleteMapping(value = "/series-teams/{seriesid}/{teamid}")
    public String deleteTeamBySeriesIdTeamsId(@PathVariable("seriesid") UUID seriesid, @PathVariable("teamid") UUID teamid) {

        seriesTeamsService.deleteTeamsBySeriesIdTeamId(seriesid, teamid);
        return "Series Team Combination with Series Id " + seriesid + "and Team Id " + teamid + " has been deleted!";
    }
}