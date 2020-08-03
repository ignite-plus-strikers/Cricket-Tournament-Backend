package com.tgt.strikers.repository;

import com.tgt.strikers.model.UserRoleById;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserRoleByIdRepository extends CassandraRepository<UserRoleById, String> {
}
