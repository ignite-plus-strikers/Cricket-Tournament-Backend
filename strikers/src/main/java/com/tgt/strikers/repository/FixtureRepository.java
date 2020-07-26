package com.tgt.strikers.repository;


import com.tgt.strikers.model.Fixture;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface FixtureRepository extends CassandraRepository<Fixture, UUID> {
}
