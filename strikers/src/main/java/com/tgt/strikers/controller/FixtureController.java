package com.tgt.strikers.controller;

import com.tgt.strikers.service.FixtureService;
import com.tgt.strikers.model.Fixture;
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
@Api(tags = "Fixture Details")
public class FixtureController {

    @Autowired
    private FixtureService fixtureService;
    //TO ADD A FIXTURE
    @ApiOperation(value = "Create New Fixture")
    @PostMapping("/fixture")
    public Fixture createFixture(@Valid @RequestBody Fixture fixture){
        fixture.setFixtureId(UUID.randomUUID());
        return fixtureService.createFixture(fixture);
    }
    //TO FETCH ALL FIXTURES
    @ApiOperation(value = "Get All Fixtures")
    @GetMapping("/fixtures")
    public List<Fixture>  getFixtures(){
        return fixtureService.getFixtures();
    }
    //TO DELETE A FIXTURE
    @ApiOperation(value = "Delete Fixture")
    @DeleteMapping("/fixture/{id}")
    public String deleteFixtureById(@PathVariable("id") UUID fixtureId){
        return fixtureService.deleteFixtureById(fixtureId);
    }
    //TO FETCH A FIXTURE BY ID
    @ApiOperation(value = "Get Fixture By Id")
    @GetMapping("/fixture/{id}")
    public Fixture getFixtureById(@PathVariable("id") UUID fixtureId){
        return fixtureService.getFixtureById(fixtureId);
    }
    //TO UPDATE BY ID
    @ApiOperation(value = "Update Fixture")
    @PutMapping("/fixture/{id}")
    public Fixture updateFixtureById(@PathVariable ("id") UUID fixtureId, @RequestBody Fixture fixture){
        return fixtureService.updateFixtureById(fixtureId,fixture);
    }
}
