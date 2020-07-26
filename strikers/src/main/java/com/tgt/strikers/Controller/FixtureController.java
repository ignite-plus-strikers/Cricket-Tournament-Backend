package com.tgt.strikers.Controller;
import com.tgt.strikers.Service.FixtureService;
import com.tgt.strikers.model.Fixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
public class FixtureController {

    @Autowired
    private FixtureService fixtureService;
    //TO ADD A FIXTURE
    @PostMapping("/fixture")
    public Fixture createFixture(@Valid @RequestBody Fixture fixture){
        fixture.setFixture_id(UUID.randomUUID());
        return fixtureService.createFixture(fixture);
    }
    //TO FETCH ALL FIXTURES
    @GetMapping("/fixtures")
    public List<Fixture>  getFixtures(){
        return fixtureService.getFixtures();
    }
    //TO DELETE A FIXTURE
    @DeleteMapping("/fixture/{id}")
    public String deleteFixtureById(@PathVariable("id") UUID fixture_id){
        return fixtureService.deleteFixtureById(fixture_id);
    }
    //TO FETCH A FIXTURE BY ID
    @GetMapping("/fixture/{id}")
    public Fixture getFixtureById(@PathVariable("id") UUID fixture_id){
        return fixtureService.getFixtureById(fixture_id);
    }
    //TO UPDATE BY ID
    @PutMapping("/fixture/{id}")
    public Fixture updateFixtureById(@PathVariable ("id") UUID fixture_id, @RequestBody Fixture fixture){
        return fixtureService.updateFixtureById(fixture_id,fixture);
    }
}
