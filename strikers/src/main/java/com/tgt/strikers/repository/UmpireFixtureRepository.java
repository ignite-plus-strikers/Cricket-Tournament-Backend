package com.tgt.strikers.repository;

import com.tgt.strikers.model.UmpireFixture;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface UmpireFixtureRepository extends CassandraRepository<UmpireFixture, UUID> {
}
