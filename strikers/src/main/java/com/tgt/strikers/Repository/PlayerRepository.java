package com.tgt.strikers.repository;

import java.util.UUID;

import com.tgt.strikers.model.Player;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface PlayerRepository extends CassandraRepository<Player, UUID> {


}