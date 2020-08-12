package com.tgt.strikers.repository;

import com.tgt.strikers.model.UserRoleByEmailId;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserRoleByEmailIdRepository extends CassandraRepository<UserRoleByEmailId, String> {
}
