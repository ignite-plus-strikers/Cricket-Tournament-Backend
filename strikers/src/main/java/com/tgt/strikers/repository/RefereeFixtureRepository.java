package com.tgt.strikers.repository;

import com.tgt.strikers.model.RefereeFixture;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface RefereeFixtureRepository extends CassandraRepository<RefereeFixture, UUID> {
}
