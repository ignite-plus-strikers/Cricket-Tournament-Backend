package com.tgt.strikers.controller;


import com.tgt.strikers.model.BowlerByMatch;
import com.tgt.strikers.service.BowlerByMatchService;
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
@Api(tags = "Bowler By Match")
public class BowlerByMatchController {

    @Autowired
    private BowlerByMatchService bowlerByMatchService;

    //-------------------------------------------------Create New BowlerByMatch-------------------------------------------------
    @ApiOperation(value = "Create New Bowler")
    @PostMapping("/bowler-by-match")
    public BowlerByMatch createBowlerByMatch(@Valid @RequestBody BowlerByMatch bowlerByMatch) {

        return bowlerByMatchService.createBowlerByMatch(bowlerByMatch);
    }


    //-------------------------------------------------Get All BowlerByMatch---------------------------------------------------
    @ApiOperation(value = "Get All Bowlers")
    @GetMapping("/bowlers-by-match")
    public List<BowlerByMatch> getAllBowlerByMatch() {

        return bowlerByMatchService.getAllBowlerByMatch();
    }

    //-----------------------------------------------Get BowlerByMatch By ID ---------------------------------------------------
    @ApiOperation(value = "Get Bowler By Match")
    @GetMapping(value = "/bowler-by-match/{id}")
    public List<BowlerByMatch> getBowlerByMatchById(@PathVariable("id") UUID id) {

        return bowlerByMatchService.getBowlerByMatchById(id);
    }

    //------------------------------------Update Particular Bowler From Bowler By Match By ID--------------------------------------
    @ApiOperation(value = "Update Bowler By Match")
    @PutMapping(value = "/bowler-by-match/{matchid}/{bowlername}")
    public BowlerByMatch updateBowlerByMatchById(@PathVariable("matchid") UUID matchid, @PathVariable("bowlername") String bowlername, @RequestBody BowlerByMatch bowlerByMatch) {

        return bowlerByMatchService.updateBowlerByMatchById(matchid, bowlername, bowlerByMatch);

    }

    //---------------------------Get a particular Bowler from Bowler By Match By Id--------------------------------------------------
    @ApiOperation(value = "Get Bowler From Match")
    @GetMapping(value = "/bowler-by-match/{matchid}/{bowlername}")
    public BowlerByMatch getBowlerByMatchIdByName(@PathVariable("matchid") UUID matchid, @PathVariable("bowlername") String bowlername) {
        return bowlerByMatchService.getBowlerByMatchIdByName(matchid, bowlername);

    }


    //-----------------------------------------------Update BowlerByMatch By ID ------------------------------------------------
/*    @PutMapping(value = "/bowler-by-match/{id}")
    public BowlerByMatch updateBowlerByMatchById(@PathVariable("id") UUID id, @RequestBody BowlerByMatch bowlerByMatch) {

        return bowlerByMatchService.updateBowlerByMatchById(id, bowlerByMatch);
    }*/

    //-------------------------------------------------Delete BowlerByMatch By ID ----------------------------------------------
/*
    @DeleteMapping(value = "/bowler-by-match/{id}")
    public String deleteBowlerByMatchById(@PathVariable("id") UUID id) {

        bowlerByMatchService.deleteBowlerByMatchById(id);
        return "BowlerByMatch with id " + id + " has been deleted!";
    }
*/


}
