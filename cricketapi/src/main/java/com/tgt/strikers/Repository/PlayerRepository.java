package com.tgt.strikers.Repository;


import com.tgt.strikers.model.players;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface PlayerRepository extends CassandraRepository<players, Integer> {


}