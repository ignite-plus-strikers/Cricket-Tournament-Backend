package com.tgt.strikers.controller;

import com.tgt.strikers.model.Scorer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tgt.strikers.service.ScorerService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class ScorerController {

    @Autowired
    private ScorerService scorerService;

    //-------------------------------------------------Create New Scorer-------------------------------------------------
    @PostMapping("/scorer")
    public Scorer createScorer(@Valid @RequestBody Scorer scorer) {
        scorer.setScorerId(UUID.randomUUID());
        return scorerService.createScorer(scorer);
    }


    //-------------------------------------------------Get All Scorer---------------------------------------------------
    @GetMapping("/scorers")
    public List<Scorer> getAllScorer() {

        return scorerService.getAllScorer();
    }

    //-----------------------------------------------Get Scorer By ID ---------------------------------------------------
    @GetMapping(value = "/scorer/{id}")
    public Scorer getScorerById(@PathVariable("id") UUID id) {

        return scorerService.getScorerById(id);
    }

    //-----------------------------------------------Update Scorer By ID ------------------------------------------------
    @PutMapping(value = "/scorer/{id}")
    public Scorer updateScorerById(@PathVariable("id") UUID id, @RequestBody Scorer scorer) {

        return scorerService.updateScorerById(id, scorer);
    }

    //-------------------------------------------------Delete Scorer By ID ----------------------------------------------
    @DeleteMapping(value = "/scorer/{id}")
    public String deleteScorerById(@PathVariable("id") UUID id) {

        scorerService.deleteScorerById(id);
        return "Scorer with id " + id + " has been deleted!";
    }




//    @GetMapping(value = "/scorer/category/{p_category}")
//    public Scorers getScorerByCategory(@PathVariable("p_category") String p_category) {
//        return scorerService.getScorerByCategory(p_category);
//    }

}
