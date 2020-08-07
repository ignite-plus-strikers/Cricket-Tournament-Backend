package com.tgt.strikers.repository;

import com.tgt.strikers.model.PreMatch;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface PreMatchRepository extends CassandraRepository <PreMatch, UUID> {
}