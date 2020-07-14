package com.example.cricketapi.dao;

import com.example.cricketapi.model.Players;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface PlayerDAO extends CassandraRepository<Players, Integer> {


}
