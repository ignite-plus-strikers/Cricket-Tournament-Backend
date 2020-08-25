package com.tgt.strikers.controller;

import com.tgt.strikers.model.PreMatch;
import com.tgt.strikers.service.PreMatchService;
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
@Api(tags = "Pre-Match Details")
public class PreMatchController {

    @Autowired
    private PreMatchService preMatchService;

    //-------------------------------------------------Create New PreMatch-------------------------------------------------
    @ApiOperation(value = "Create New Pre-Match")
    @PostMapping("/pre-match")
    public PreMatch createPreMatch(@Valid @RequestBody PreMatch preMatch) {

        return preMatchService.createPreMatch(preMatch);
    }


    //-------------------------------------------------Get All PreMatch---------------------------------------------------
    @ApiOperation(value = "Get All Pre-Match")
    @GetMapping("/pre-matches")
    public List<PreMatch> getAllPreMatch() {

        return preMatchService.getAllPreMatch();
    }

    //-----------------------------------------------Get PreMatch By ID ---------------------------------------------------
    @ApiOperation(value = "Get Pre-Match By Id")
    @GetMapping(value = "/pre-match/{id}")
    public PreMatch getPreMatchById(@PathVariable("id") UUID id) {

        return preMatchService.getPreMatchById(id);
    }


}
