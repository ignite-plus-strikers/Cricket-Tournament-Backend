package com.tgt.strikers.repository;

import com.tgt.strikers.model.Counter;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface CounterRepository extends CassandraRepository<Counter, UUID> {
}
