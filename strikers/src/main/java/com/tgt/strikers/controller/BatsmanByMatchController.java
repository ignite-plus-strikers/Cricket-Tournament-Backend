package com.tgt.strikers.controller;

import com.tgt.strikers.model.BatsmanByMatch;
import com.tgt.strikers.service.BatsmanByMatchService;
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
@Api(tags = "Batsman By Match")
public class BatsmanByMatchController {

    @Autowired
    private BatsmanByMatchService batsmanByMatchService;

    //-------------------------------------------------Create New BatsmanByMatch-------------------------------------------------
    @ApiOperation(value = "Create New Batsman")
    @PostMapping("/batsman-by-match")
    public BatsmanByMatch createBatsmanByMatch(@Valid @RequestBody BatsmanByMatch batsmanByMatch) {

        return batsmanByMatchService.createBatsmanByMatch(batsmanByMatch);
    }


    //-------------------------------------------------Get All BatsmanByMatch---------------------------------------------------
    @ApiOperation(value = "Get All Batsmen")
    @GetMapping("/batsmen-by-match")
    public List<BatsmanByMatch> getAllBatsmanByMatch() {

        return batsmanByMatchService.getAllBatsmanByMatch();
    }

    //-----------------------------------------------Get BatsmanByMatch By ID ---------------------------------------------------
    @ApiOperation(value = "Get Batsman By Match")
    @GetMapping(value = "/batsman-by-match/{id}")
    public List<BatsmanByMatch> getBatsmanByMatchById(@PathVariable("id") UUID id) {

        return batsmanByMatchService.getBatsmanByMatchById(id);
    }


    //------------------------------------Update Particular Batsman From Batsman By Match By ID--------------------------------------
    @ApiOperation(value = "Update Batsman By Match")
    @PutMapping(value = "/batsman-by-match/{matchid}/{batsmanname}")
    public BatsmanByMatch updateBatsmanByMatchById(@PathVariable("matchid") UUID matchid, @PathVariable("batsmanname") String batsmanname,  @RequestBody BatsmanByMatch batsmanByMatch) {

        return batsmanByMatchService.updateBatsmanByMatchById(matchid, batsmanname, batsmanByMatch);
    }

    //-----------------------------------------------Update BatsmanByMatch By ID ------------------------------------------------
/*    @PutMapping(value = "/batsman-by-match/{id}")
    public BatsmanByMatch updateBatsmanByMatchById(@PathVariable("id") UUID id, @RequestBody BatsmanByMatch batsmanByMatch) {

        return batsmanByMatchService.updateBatsmanByMatchById(id, batsmanByMatch);
    }*/

    //-------------------------------------------------Delete BatsmanByMatch By ID ----------------------------------------------
/*
    @DeleteMapping(value = "/batsman-by-match/{id}")
    public String deleteBatsmanByMatchById(@PathVariable("id") UUID id) {

        batsmanByMatchService.deleteBatsmanByMatchById(id);
        return "BatsmanByMatch with id " + id + " has been deleted!";
    }
*/


}
