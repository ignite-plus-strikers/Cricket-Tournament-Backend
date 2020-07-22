package com.tgt.strikers.Repository;


import com.tgt.strikers.model.Player;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface PlayerRepository extends CassandraRepository<Player, UUID> {

//    @AllowFiltering
//    Players findByCategory(String p_category);


}