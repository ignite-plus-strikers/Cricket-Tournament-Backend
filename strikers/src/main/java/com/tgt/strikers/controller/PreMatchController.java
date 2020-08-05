package com.tgt.strikers.controller;

import com.tgt.strikers.model.PreMatch;
import com.tgt.strikers.service.PreMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class PreMatchController {

    @Autowired
    private PreMatchService preMatchService;

    //-------------------------------------------------Create New PreMatch-------------------------------------------------
    @PostMapping("/pre-match")
    public PreMatch createPreMatch(@Valid @RequestBody PreMatch preMatch) {

        return preMatchService.createPreMatch(preMatch);
    }


    //-------------------------------------------------Get All PreMatch---------------------------------------------------
    @GetMapping("/pre-matches")
    public List<PreMatch> getAllPreMatch() {

        return preMatchService.getAllPreMatch();
    }

    //-----------------------------------------------Get PreMatch By ID ---------------------------------------------------
    @GetMapping(value = "/pre-match/{id}")
    public PreMatch getPreMatchById(@PathVariable("id") UUID id) {

        return preMatchService.getPreMatchById(id);
    }

    //-----------------------------------------------Update PreMatch By ID ------------------------------------------------
/*    @PutMapping(value = "/preMatch/{id}")
    public PreMatch updatePreMatchById(@PathVariable("id") UUID id, @RequestBody PreMatch preMatch) {

        return preMatchService.updatePreMatchById(id, preMatch);
    }*/

    //-------------------------------------------------Delete PreMatch By ID ----------------------------------------------
/*
    @DeleteMapping(value = "/preMatch/{id}")
    public String deletePreMatchById(@PathVariable("id") UUID id) {

        preMatchService.deletePreMatchById(id);
        return "PreMatch with id " + id + " has been deleted!";
    }
*/

}
