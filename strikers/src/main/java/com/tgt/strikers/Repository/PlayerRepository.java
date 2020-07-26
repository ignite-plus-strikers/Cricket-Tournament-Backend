package com.tgt.strikers.Repository;


import com.tgt.strikers.model.Player;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerRepository extends CassandraRepository<Player, UUID> {

//    @AllowFiltering
//    Players findByCategory(String p_category);


}