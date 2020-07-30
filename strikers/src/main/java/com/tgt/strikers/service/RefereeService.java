package com.tgt.strikers.service;

import com.tgt.strikers.exception.RefereeNotFoundException;
import com.tgt.strikers.model.Referee;
import com.tgt.strikers.repository.RefereeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefereeService {

    @Autowired
    private RefereeRepository refereeRepo;

    //-------------------------------------------------Create New Referee-------------------------------------------------
    public Referee createReferee(Referee referee) {

        return refereeRepo.save(referee);
    }


    //-------------------------------------------------Get All Referees---------------------------------------------------
    public List<Referee> getAllReferee() {

        return refereeRepo.findAll();
    }


    //-----------------------------------------------Get Referee By ID ---------------------------------------------------
    public Referee getRefereeById(UUID id) {

        Optional<Referee> optionalReferee = refereeRepo.findById(id);
        if (!optionalReferee.isPresent())
            throw new RefereeNotFoundException("Referee Record with id " + id + " is not available!");
        return refereeRepo.findById(id).get();
    }


    //-----------------------------------------------Update Umpire By ID ------------------------------------------------
    public Referee updateRefereeById(UUID id, Referee referee) {

        Optional<Referee> optionalReferee = refereeRepo.findById(id);
        if (!optionalReferee.isPresent())
            throw new RefereeNotFoundException("Referee Record with id " + id + " is not available!");
        referee.setRefereeId(id);
        return refereeRepo.save(referee);
    }


    //-------------------------------------------------Delete Referee By ID ----------------------------------------------
    public void deleteRefereeById(UUID id) {

        Optional<Referee> optionalReferee = refereeRepo.findById(id);
        if (!optionalReferee.isPresent())
            throw new RefereeNotFoundException("Referee Record with id " + id + " is not available!");
        refereeRepo.deleteById(id);
    }

}
