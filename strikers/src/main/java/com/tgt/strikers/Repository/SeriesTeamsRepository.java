package com.tgt.strikers.Repository;

import com.tgt.strikers.model.SeriesTeams;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface SeriesTeamsRepository  extends CassandraRepository<SeriesTeams, UUID> {
}
