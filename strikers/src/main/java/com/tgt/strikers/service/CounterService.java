package com.tgt.strikers.service;


import com.tgt.strikers.exception.FixtureNotFoundException;
import com.tgt.strikers.model.Counter;
import com.tgt.strikers.repository.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CounterService {

    @Autowired
    private CounterRepository counterRepository;

    public List<Counter> getAllCounter(){
        return counterRepository.findAll();
    }


    public Counter updateCounterById(UUID counter_id,Counter counter){
        Optional<Counter> optionalCounter = counterRepository.findById(counter_id);
        if(!optionalCounter.isPresent())
            throw new FixtureNotFoundException("Invalid");
        return counterRepository.save(counter);
    }
}
