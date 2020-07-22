package com.tgt.strikers.Repository;

import java.util.UUID;
import com.tgt.strikers.model.Teams;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface TeamRepository extends CassandraRepository<Teams, UUID> {


}
