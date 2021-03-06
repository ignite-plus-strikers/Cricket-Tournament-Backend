package com.tgt.strikers.controller;

import com.tgt.strikers.service.SeriesService;
import com.tgt.strikers.model.Series;
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
@Api(tags = "Series Details")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    //-------------------------------------------------Create New Series-------------------------------------------------
    @ApiOperation(value = "Create New Series")
    @PostMapping("/series")
    public Series createSeries(@Valid @RequestBody Series series) {
        series.setSeriesId(UUID.randomUUID());

        return seriesService.createSeries(series);
    }


    //-------------------------------------------------Get All Series---------------------------------------------------
    @ApiOperation(value = "Get All Series")
    @GetMapping("/series")
    public List<Series> getAllSeries() {

        return seriesService.getAllSeries();
    }

    //-----------------------------------------------Get Series By ID ---------------------------------------------------
    @ApiOperation(value = "Get Series By Id")
    @GetMapping(value = "/series/{id}")
    public Series getSeriesById(@PathVariable("id") UUID id) {

        return seriesService.getSeriesById(id);
    }

    //-----------------------------------------------Update Series By ID ------------------------------------------------
    @ApiOperation(value = "Update Series")
    @PutMapping(value = "/series/{id}")
    public Series updateSeriesById(@PathVariable("id") UUID id, @RequestBody Series series) {

        return seriesService.updateSeriesById(id, series);
    }

    //-------------------------------------------------Delete Series By ID ----------------------------------------------
    @ApiOperation(value = "Delete Series")
    @DeleteMapping(value = "/series/{id}")
    public String deleteSeriesById(@PathVariable("id") UUID id) {

        seriesService.deleteSeriesById(id);
        return "Series with id " + id + " has been deleted!";
    }


}
