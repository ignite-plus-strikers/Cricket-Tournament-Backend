package com.tgt.strikers.repository;

import com.tgt.strikers.model.Umpire;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UmpireRepository extends CassandraRepository<Umpire, UUID> {
}