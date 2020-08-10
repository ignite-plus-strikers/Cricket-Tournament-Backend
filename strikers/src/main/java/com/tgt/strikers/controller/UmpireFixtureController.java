package com.tgt.strikers.controller;

import com.tgt.strikers.model.UmpireFixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tgt.strikers.service.UmpireFixtureService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class UmpireFixtureController {

    @Autowired
    private UmpireFixtureService umpireFixtureService;

    //-------------------------------------------------Create New UmpireFixture-------------------------------------------------
    @PostMapping("/umpire-fixture")
    public UmpireFixture createUmpireFixture(@Valid @RequestBody UmpireFixture umpireFixture) {
        umpireFixture.setUmpireId(UUID.randomUUID());

        return umpireFixtureService.createUmpireFixture(umpireFixture);
    }


    //-------------------------------------------------Get All UmpireFixture---------------------------------------------------
    @GetMapping("/umpire-fixtures")
    public List<UmpireFixture> getAllUmpireFixture() {

        return umpireFixtureService.getAllUmpireFixture();
    }

    //-----------------------------------------------Get UmpireFixture By ID ---------------------------------------------------
    @GetMapping(value = "/umpire-fixture/{id}")
    public UmpireFixture getUmpireFixtureById(@PathVariable("id") UUID id) {

        return umpireFixtureService.getUmpireFixtureById(id);
    }

    //-----------------------------------------------Update UmpireFixture By ID ------------------------------------------------
    @PutMapping(value = "/umpire-fixture/{id}")
    public UmpireFixture updateUmpireFixtureById(@PathVariable("id") UUID id, @RequestBody UmpireFixture umpireFixture) {

        return umpireFixtureService.updateUmpireFixtureById(id, umpireFixture);
    }

    //-------------------------------------------------Delete UmpireFixture By ID ----------------------------------------------
    @DeleteMapping(value = "/umpire-fixture/{id}")
    public String deleteUmpireFixtureById(@PathVariable("id") UUID id) {

        umpireFixtureService.deleteUmpireFixtureById(id);
        return "UmpireFixture with id " + id + " has been deleted!";
    }



//    @GetMapping(value = "/umpireFixture/category/{p_category}")
//    public UmpireFixtures getUmpireFixtureByCategory(@PathVariable("p_category") String p_category) {
//        return umpireFixtureService.getUmpireFixtureByCategory(p_category);
//    }

}
