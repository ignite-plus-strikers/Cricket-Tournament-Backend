package com.tgt.strikers.repository;

import com.tgt.strikers.model.ScorerCred;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ScorerCredRepository extends CassandraRepository<ScorerCred,String> {
}