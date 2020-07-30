package com.tgt.strikers.repository;

import com.tgt.strikers.model.Scorer;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ScorerRepository extends CassandraRepository<Scorer, UUID> {
}
