package com.tgt.strikers.repository;

import com.tgt.strikers.model.InactivePlayer;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InactivePlayerRepository extends CassandraRepository<InactivePlayer, UUID> {
}
