package com.tgt.strikers.controller;

import com.tgt.strikers.model.Umpire;
import com.tgt.strikers.service.UmpireService;
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
@Api(tags = "Umpire Details")
public class UmpireController {

    @Autowired
    private UmpireService umpireService;

    //-------------------------------------------------Create New Umpire-------------------------------------------------
    @ApiOperation(value = "Create New Umpire")
    @PostMapping("/umpire")
    public Umpire createUmpire(@Valid @RequestBody Umpire umpire) {
        umpire.setUmpireId(UUID.randomUUID());

        return umpireService.createUmpire(umpire);
    }


    //-------------------------------------------------Get All Umpire---------------------------------------------------
    @ApiOperation(value = "Get All Umpires")
    @GetMapping("/umpires")
    public List<Umpire> getAllUmpire() {

        return umpireService.getAllUmpire();
    }

    //-----------------------------------------------Get Umpire By ID ---------------------------------------------------
    @ApiOperation(value = "Get Umpire By Id")
    @GetMapping(value = "/umpire/{id}")
    public Umpire getUmpireById(@PathVariable("id") UUID id) {

        return umpireService.getUmpireById(id);
    }

    //-----------------------------------------------Update Umpire By ID ------------------------------------------------
    @ApiOperation(value = "Update Umpire")
    @PutMapping(value = "/umpire/{id}")
    public Umpire updateUmpireById(@PathVariable("id") UUID id, @RequestBody Umpire umpire) {

        return umpireService.updateUmpireById(id, umpire);
    }

    //-------------------------------------------------Delete Umpire By ID ----------------------------------------------
    @ApiOperation(value = "Delete Umpire")
    @DeleteMapping(value = "/umpire/{id}")
    public String deleteUmpireById(@PathVariable("id") UUID id, Umpire umpire) {

        umpireService.deleteUmpireById(id);
        return "Umpire with id " + id + " has been deleted!";
    }
}