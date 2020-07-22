package com.tgt.strikers.Controller;

import com.tgt.strikers.Service.SeriesTeamsService;
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
        seriesTeams.setSeriesId(UUID.randomUUID());

        return seriesTeamsService.createSeriesTeams(seriesTeams);
    }


    //----------------------------------------Get All Series Team Combination-------------------------------------------
    @GetMapping("/series-teams")
    public List<SeriesTeams> getAllSeriesTeams() {

        return seriesTeamsService.getAllSeriesTeams();
    }

    //----------------------------------------Get Series Team Combination By ID-----------------------------------------
/*    @GetMapping(value = "/series-teams/{id}")
    public SeriesTeams getSeriesTeamsById(@PathVariable("id") UUID id) {

        return seriesTeamsService.getSeriesTeamsById(id);
    }*/

    //-----------------------------------------Update Series Team Combination By ID-------------------------------------
/*
    @PutMapping(value = "/series-teams/{id}")
    public SeriesTeams updateSeriesTeamsById(@PathVariable("id") UUID id, @RequestBody SeriesTeams seriesTeams) {

        return seriesTeamsService.updateSeriesTeamsById(id, seriesTeams);
    }
*/

    //-----------------------------------------Delete Series Team Combination By ID-------------------------------------
    @DeleteMapping(value = "/series-teams/{id}")
    public String deleteSeriesTeamsById(@PathVariable("id") UUID id) {

        seriesTeamsService.deleteSeriesTeamsById(id);
        return "Series Team Combination with series id " + id + " has been deleted!";
    }

}