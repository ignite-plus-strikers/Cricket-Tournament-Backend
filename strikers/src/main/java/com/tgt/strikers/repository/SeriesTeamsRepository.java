package com.tgt.strikers.repository;

import com.tgt.strikers.model.SeriesTeams;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface SeriesTeamsRepository  extends CassandraRepository<SeriesTeams, UUID> {

    List<SeriesTeams> findBySeriesId(UUID seriesId);
}