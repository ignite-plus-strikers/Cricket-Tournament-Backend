package com.tgt.strikers.controller;

import com.tgt.strikers.model.RefereeFixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tgt.strikers.service.RefereeFixtureService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class RefereeFixtureController {

    @Autowired
    private RefereeFixtureService refereeFixtureService;

    //-------------------------------------------------Create New RefereeFixture-------------------------------------------------
    @PostMapping("/referee-fixture")
    public RefereeFixture createRefereeFixture(@Valid @RequestBody RefereeFixture refereeFixture) {
        refereeFixture.setRefereeId(UUID.randomUUID());

        return refereeFixtureService.createRefereeFixture(refereeFixture);
    }


    //-------------------------------------------------Get All RefereeFixture---------------------------------------------------
    @GetMapping("/referee-fixtures")
    public List<RefereeFixture> getAllRefereeFixture() {

        return refereeFixtureService.getAllRefereeFixture();
    }

    //-----------------------------------------------Get RefereeFixture By ID ---------------------------------------------------
    @GetMapping(value = "/referee-fixture/{id}")
    public RefereeFixture getRefereeFixtureById(@PathVariable("id") UUID id) {

        return refereeFixtureService.getRefereeFixtureById(id);
    }

    //-----------------------------------------------Update RefereeFixture By ID ------------------------------------------------
    @PutMapping(value = "/referee-fixture/{id}")
    public RefereeFixture updateRefereeFixtureById(@PathVariable("id") UUID id, @RequestBody RefereeFixture refereeFixture) {

        return refereeFixtureService.updateRefereeFixtureById(id, refereeFixture);
    }

    //-------------------------------------------------Delete RefereeFixture By ID ----------------------------------------------
    @DeleteMapping(value = "/referee-fixture/{id}")
    public String deleteRefereeFixtureById(@PathVariable("id") UUID id) {

        refereeFixtureService.deleteRefereeFixtureById(id);
        return "RefereeFixture with id " + id + " has been deleted!";
    }



//    @GetMapping(value = "/refereeFixture/category/{p_category}")
//    public RefereeFixtures getRefereeFixtureByCategory(@PathVariable("p_category") String p_category) {
//        return refereeFixtureService.getRefereeFixtureByCategory(p_category);
//    }

}
