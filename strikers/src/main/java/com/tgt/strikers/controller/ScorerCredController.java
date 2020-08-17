package com.tgt.strikers.controller;

import com.tgt.strikers.model.ScorerCred;
import com.tgt.strikers.service.ScorerCredService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
@Api(tags = "Scorer Credentials")
public class ScorerCredController {

    @Autowired
    private ScorerCredService scorerCredService;

    //-------------------------------------------------Create New Scorer-------------------------------------------------
    @ApiOperation(value = "Create New Scorer")
    @PostMapping("/scorer-cred")
    public String createScorerCred(@RequestBody ScorerCred scorer) {
        return scorerCredService.createScorerCred(scorer);
    }

    //-------------------------------------------------Get All Scorers---------------------------------------------------
    @ApiOperation(value = "Get All Scorers")
    @GetMapping("/scorer-creds")
    public List<ScorerCred> getAllScorerCred() {
        return scorerCredService.getAllScorerCred();
    }
}