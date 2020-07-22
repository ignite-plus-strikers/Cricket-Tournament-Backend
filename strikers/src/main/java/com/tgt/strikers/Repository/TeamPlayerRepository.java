package com.tgt.strikers.Repository;

import com.tgt.strikers.model.TeamPlayer;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface TeamPlayerRepository extends CassandraRepository<TeamPlayer, UUID> {
}
