package com.tgt.strikers.Repository;


import com.tgt.strikers.model.Players;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface PlayerRepository extends CassandraRepository<Players, UUID> {

//    @AllowFiltering
//    Players findByCategory(String p_category);


}