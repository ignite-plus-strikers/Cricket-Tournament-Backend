package com.tgt.strikers.controller;

import com.tgt.strikers.model.ScorerFixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tgt.strikers.service.ScorerFixtureService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class ScorerFixtureController {

    @Autowired
    private ScorerFixtureService scorerFixtureService;

    //-------------------------------------------------Create New ScorerFixture-------------------------------------------------
    @PostMapping("/scorer-fixture")
    public ScorerFixture createScorerFixture(@Valid @RequestBody ScorerFixture scorerFixture) {
        scorerFixture.setScorerId(UUID.randomUUID());

        return scorerFixtureService.createScorerFixture(scorerFixture);
    }


    //-------------------------------------------------Get All ScorerFixture---------------------------------------------------
    @GetMapping("/scorer-fixtures")
    public List<ScorerFixture> getAllScorerFixture() {

        return scorerFixtureService.getAllScorerFixture();
    }

    //-----------------------------------------------Get ScorerFixture By ID ---------------------------------------------------
    @GetMapping(value = "/scorer-fixture/{id}")
    public ScorerFixture getScorerFixtureById(@PathVariable("id") UUID id) {

        return scorerFixtureService.getScorerFixtureById(id);
    }

    //-----------------------------------------------Update ScorerFixture By ID ------------------------------------------------
    @PutMapping(value = "/scorer-fixture/{id}")
    public ScorerFixture updateScorerFixtureById(@PathVariable("id") UUID id, @RequestBody ScorerFixture scorerFixture) {

        return scorerFixtureService.updateScorerFixtureById(id, scorerFixture);
    }

    //-------------------------------------------------Delete ScorerFixture By ID ----------------------------------------------
    @DeleteMapping(value = "/scorer-fixture/{id}")
    public String deleteScorerFixtureById(@PathVariable("id") UUID id) {

        scorerFixtureService.deleteScorerFixtureById(id);
        return "ScorerFixture with id " + id + " has been deleted!";
    }



//    @GetMapping(value = "/scorerFixture/category/{p_category}")
//    public ScorerFixtures getScorerFixtureByCategory(@PathVariable("p_category") String p_category) {
//        return scorerFixtureService.getScorerFixtureByCategory(p_category);
//    }

}
