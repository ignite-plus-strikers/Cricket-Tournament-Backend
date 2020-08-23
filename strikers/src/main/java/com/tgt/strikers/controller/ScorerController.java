package com.tgt.strikers.controller;

import com.tgt.strikers.model.Scorer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tgt.strikers.service.ScorerService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
@Api(tags = "Scorer Details")
public class ScorerController {

    @Autowired
    private ScorerService scorerService;

    //-------------------------------------------------Create New Scorer-------------------------------------------------
    @ApiOperation(value = "Create New Scorer")
    @PostMapping("/scorer")
    public Scorer createScorer(@Valid @RequestBody Scorer scorer) {
        return scorerService.createScorer(scorer);
    }


    //-------------------------------------------------Get All Scorer---------------------------------------------------
    @ApiOperation(value = "Get All Scorers")
    @GetMapping("/scorers")
    public List<Scorer> getAllScorer() {

        return scorerService.getAllScorer();
    }

    //-----------------------------------------------Get Scorer By ID ---------------------------------------------------
    @ApiOperation(value = "Get Scorer By Id")
    @GetMapping(value = "/scorer/{id}")
    public Scorer getScorerById(@PathVariable("id") String id) {

        return scorerService.getScorerById(id);
    }

    //-----------------------------------------------Update Scorer By ID ------------------------------------------------
    @ApiOperation(value = "Update Scorer")
    @PutMapping(value = "/scorer/{id}")
    public Scorer updateScorerById(@PathVariable("id") String id, @RequestBody Scorer scorer) {

        return scorerService.updateScorerById(id, scorer);
    }

    //-------------------------------------------------Delete Scorer By ID ----------------------------------------------
    @ApiOperation(value = "Delete Scorer")
    @DeleteMapping(value = "/scorer/{id}")
    public String deleteScorerById(@PathVariable("id") String id) {

        scorerService.deleteScorerById(id);
        return "Scorer with id " + id + " has been deleted!";
    }




//    @GetMapping(value = "/scorer/category/{p_category}")
//    public Scorers getScorerByCategory(@PathVariable("p_category") String p_category) {
//        return scorerService.getScorerByCategory(p_category);
//    }

}
