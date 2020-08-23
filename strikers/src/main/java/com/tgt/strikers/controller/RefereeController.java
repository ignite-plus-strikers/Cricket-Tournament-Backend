package com.tgt.strikers.controller;

import com.tgt.strikers.model.Referee;
import com.tgt.strikers.service.RefereeService;
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
@Api(tags = "Referee Details")
public class RefereeController {

    @Autowired
    private RefereeService refereeService;

    //-------------------------------------------------Create New Referee-------------------------------------------------
    @ApiOperation(value = "Create New Referee")
    @PostMapping("/referee")
    public Referee createReferee(@Valid @RequestBody Referee referee) {
        referee.setRefereeId(UUID.randomUUID());

        return refereeService.createReferee(referee);
    }


    //-------------------------------------------------Get All Referee---------------------------------------------------
    @ApiOperation(value = "Get All Referees")
    @GetMapping("/referees")
    public List<Referee> getAllReferee() {

        return refereeService.getAllReferee();
    }

    //-----------------------------------------------Get Referee By ID ---------------------------------------------------
    @ApiOperation(value = "Get Referee By Id")
    @GetMapping(value = "/referee/{id}")
    public Referee getRefereeById(@PathVariable("id") UUID id) {

        return refereeService.getRefereeById(id);
    }

    //-----------------------------------------------Update Referee By ID ------------------------------------------------
    @ApiOperation(value = "Update Referee")
    @PutMapping(value = "/referee/{id}")
    public Referee updateRefereeById(@PathVariable("id") UUID id, @RequestBody Referee umpire) {

        return refereeService.updateRefereeById(id, umpire);
    }

    //-------------------------------------------------Delete Referee By ID ----------------------------------------------
    @ApiOperation(value = "Delete Referee")
    @DeleteMapping(value = "/referee/{id}")
    public String deleteRefereeById(@PathVariable("id") UUID id, Referee referee) {

        refereeService.deleteRefereeById(id);
        return "Referee with id " + id + " has been deleted!";
    }
}