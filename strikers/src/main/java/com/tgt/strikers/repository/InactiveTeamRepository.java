package com.tgt.strikers.repository;

import com.tgt.strikers.model.InactiveTeam;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InactiveTeamRepository extends CassandraRepository<InactiveTeam, UUID> {
}
