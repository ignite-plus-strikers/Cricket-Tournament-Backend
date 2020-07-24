package com.tgt.strikers.service;

import com.tgt.strikers.exception.SeriesNotFoundException;
import com.tgt.strikers.repository.SeriesRepository;
import com.tgt.strikers.model.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SeriesService {

    @Autowired
    private SeriesRepository seriesRepo;

    //-------------------------------------------------Create New Series-------------------------------------------------
    public Series createSeries(Series series) {

        return seriesRepo.save(series);
    }


    //-------------------------------------------------Get All Series---------------------------------------------------
    public List<Series> getAllSeries() {

        return seriesRepo.findAll();
    }


    //-----------------------------------------------Get Series By ID ---------------------------------------------------
    public Series getSeriesById(UUID id) {

        Optional<Series> optionalSeries = seriesRepo.findById(id);
        if (!optionalSeries.isPresent())
            throw new SeriesNotFoundException("Series Record with Series Id " + id + " is not available");
        return seriesRepo.findById(id).get();
    }


    //-----------------------------------------------Update Series By ID ------------------------------------------------
    public Series updateSeriesById(UUID id, Series series) {

        Optional<Series> optionalSeries = seriesRepo.findById(id);
        if (!optionalSeries.isPresent())
            throw new SeriesNotFoundException("Series Record with Series Id " + id + " is not available");
        series.setSeriesId(id);
        return seriesRepo.save(series);
    }


    //-------------------------------------------------Delete Series By ID ----------------------------------------------
    public void deleteSeriesById(UUID id) {

        Optional<Series> optionalSeries = seriesRepo.findById(id);
        if (!optionalSeries.isPresent())
            throw new SeriesNotFoundException("Series Record with Series Id " + id + " is not available");
        seriesRepo.deleteById(id);
    }
}
