package com.tgt.strikers.repository;

import com.tgt.strikers.model.ScorerFixture;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ScorerFixtureRepository extends CassandraRepository<ScorerFixture, UUID> {
}
