package com.tgt.strikers.repository;


import com.tgt.strikers.model.BatsmanByMatch;
import com.tgt.strikers.model.BowlerByMatch;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BowlerByMatchRepository extends CassandraRepository<BowlerByMatch, UUID> {

    List<BowlerByMatch> findByMatchId(UUID matchId);
}
