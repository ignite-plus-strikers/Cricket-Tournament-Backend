package com.tgt.strikers.repository;

import com.tgt.strikers.model.TeamPlayer;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface TeamPlayerRepository extends CassandraRepository<TeamPlayer, UUID> {

  List<TeamPlayer> findByTeamId(UUID teamId);
}
