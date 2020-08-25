package com.tgt.strikers.controller;

import com.tgt.strikers.model.UmpireFixture;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tgt.strikers.service.UmpireFixtureService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
@Api(tags = "Umpire By Fixture Details")
public class UmpireFixtureController {

    @Autowired
    private UmpireFixtureService umpireFixtureService;

    //-------------------------------------------------Create New UmpireFixture-------------------------------------------------
    @ApiOperation(value = "Create New Player")
    @PostMapping("/umpire-fixture")
    public UmpireFixture createUmpireFixture(@Valid @RequestBody UmpireFixture umpireFixture) {
        umpireFixture.setUmpireId(UUID.randomUUID());

        return umpireFixtureService.createUmpireFixture(umpireFixture);
    }


    //-------------------------------------------------Get All UmpireFixture---------------------------------------------------
    @ApiOperation(value = "Get All Umpire By Fixture")
    @GetMapping("/umpire-fixtures")
    public List<UmpireFixture> getAllUmpireFixture() {

        return umpireFixtureService.getAllUmpireFixture();
    }

    //-----------------------------------------------Get UmpireFixture By ID ---------------------------------------------------
    @ApiOperation(value = "Get Umpire By Fixture")
    @GetMapping(value = "/umpire-fixture/{id}")
    public UmpireFixture getUmpireFixtureById(@PathVariable("id") UUID id) {

        return umpireFixtureService.getUmpireFixtureById(id);
    }

    //-----------------------------------------------Update UmpireFixture By ID ------------------------------------------------
    @ApiOperation(value = "Update Umpire By Fixture")
    @PutMapping(value = "/umpire-fixture/{id}")
    public UmpireFixture updateUmpireFixtureById(@PathVariable("id") UUID id, @RequestBody UmpireFixture umpireFixture) {

        return umpireFixtureService.updateUmpireFixtureById(id, umpireFixture);
    }

    //-------------------------------------------------Delete UmpireFixture By ID ----------------------------------------------
    @ApiOperation(value = "Delete Umpire By Fixture")
    @DeleteMapping(value = "/umpire-fixture/{id}")
    public String deleteUmpireFixtureById(@PathVariable("id") UUID id) {

        umpireFixtureService.deleteUmpireFixtureById(id);
        return "UmpireFixture with id " + id + " has been deleted!";
    }

}
