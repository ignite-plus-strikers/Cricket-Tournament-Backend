package com.tgt.strikers.controller;

import com.tgt.strikers.model.ScorerFixture;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tgt.strikers.service.ScorerFixtureService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
@Api(tags = "Scorer By Fixture Details")
public class ScorerFixtureController {

    @Autowired
    private ScorerFixtureService scorerFixtureService;

    //-------------------------------------------------Create New ScorerFixture-------------------------------------------------
    @ApiOperation(value = "Create New Scorer By Fixture")
    @PostMapping("/scorer-fixture")
    public ScorerFixture createScorerFixture(@Valid @RequestBody ScorerFixture scorerFixture) {

        return scorerFixtureService.createScorerFixture(scorerFixture);
    }


    //-------------------------------------------------Get All ScorerFixture---------------------------------------------------
    @ApiOperation(value = "Get All Scorers By Fixture")
    @GetMapping("/scorer-fixtures")
    public List<ScorerFixture> getAllScorerFixture() {

        return scorerFixtureService.getAllScorerFixture();
    }

    //-----------------------------------------------Get ScorerFixture By ID ---------------------------------------------------
    @ApiOperation(value = "Get Scorer By Fixture")
    @GetMapping(value = "/scorer-fixture/{id}")
    public ScorerFixture getScorerFixtureById(@PathVariable("id") String id) {

        return scorerFixtureService.getScorerFixtureById(id);
    }

    //-----------------------------------------------Update ScorerFixture By ID ------------------------------------------------
    @ApiOperation(value = "Update Scorer By Fixture")
    @PutMapping(value = "/scorer-fixture/{id}")
    public ScorerFixture updateScorerFixtureById(@PathVariable("id") String id, @RequestBody ScorerFixture scorerFixture) {

        return scorerFixtureService.updateScorerFixtureById(id, scorerFixture);
    }

    //-------------------------------------------------Delete ScorerFixture By ID ----------------------------------------------
    @ApiOperation(value = "Delete Scorer By Fixture")
    @DeleteMapping(value = "/scorer-fixture/{id}")
    public String deleteScorerFixtureById(@PathVariable("id") String id) {

        scorerFixtureService.deleteScorerFixtureById(id);
        return "ScorerFixture with id " + id + " has been deleted!";
    }

}
