package com.tgt.strikers.controller;

import com.tgt.strikers.model.MatchResult;
import com.tgt.strikers.service.MatchResultService;
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
@Api(tags = "Match Result")
public class MatchResultController {

    @Autowired
    private MatchResultService matchResultService;

    //-------------------------------------------------Create New MatchResult-------------------------------------------------
    @ApiOperation(value = "Create New Match Result")
    @PostMapping("/match-result")
    public MatchResult createMatchResult(@Valid @RequestBody MatchResult matchResult) {

        return matchResultService.createMatchResult(matchResult);
    }


    //-------------------------------------------------Get All MatchResult---------------------------------------------------
    @ApiOperation(value = "Get All Match Result")
    @GetMapping("/match-results")
    public List<MatchResult> getAllMatchResult() {

        return matchResultService.getAllMatchResult();
    }

    //-----------------------------------------------Get MatchResult By ID ---------------------------------------------------
    @ApiOperation(value = "Get Match Result By Id")
    @GetMapping(value = "/match-result/{id}")
    public MatchResult getMatchResultById(@PathVariable("id") UUID id) {

        return matchResultService.getMatchResultById(id);
    }

    //-----------------------------------------------Update MatchResult By ID ------------------------------------------------
    @ApiOperation(value = "Update Match Result")
    @PutMapping(value = "/match-result/{id}")
    public MatchResult updateMatchResultById(@PathVariable("id") UUID id, @RequestBody MatchResult matchResult) {

        return matchResultService.updateMatchResultById(id, matchResult);
    }

    //-------------------------------------------------Delete MatchResult By ID ----------------------------------------------
/*
    @DeleteMapping(value = "/match-result/{id}")
    public String deleteMatchResultById(@PathVariable("id") UUID id) {

        matchResultService.deleteMatchResultById(id);
        return "MatchResult with id " + id + " has been deleted!";
    }
*/


}
