package com.tgt.strikers.controller;


import com.tgt.strikers.model.Counter;
import com.tgt.strikers.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class CounterController {

    @Autowired
    private CounterService counterService;

    //--------------TO GET COUNT--------------------------//

    @GetMapping("/counters")
    public List<Counter> getAllCounter(){
        return counterService.getAllCounter();
    }

    @PutMapping("/counter/{id}")
    public Counter updateCounterById(@PathVariable ("id")UUID counter_id,@RequestBody Counter counter){
        return counterService.updateCounterById(counter_id,counter);
    }


}
