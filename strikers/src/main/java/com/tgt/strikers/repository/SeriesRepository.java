package com.tgt.strikers.repository;

import com.tgt.strikers.model.Series;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface SeriesRepository extends CassandraRepository<Series, UUID> {

//    int page = 0, size = 10;

//    Pageable pageable = PageRequest.of(page, size, new Sort( Sort.Direction.ASC, "seriesStartDate"));
//        List<Series> findAllByOrderBySeriesStartDateAsc();
}