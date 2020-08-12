package com.tgt.strikers.repository;

import com.tgt.strikers.model.UserRoleByEmailId;
import org.springframework.stereotype.Repository;
import org.springframework.data.cassandra.repository.CassandraRepository;

@Repository
public interface AuthRepository extends CassandraRepository<UserRoleByEmailId, String> {
}

