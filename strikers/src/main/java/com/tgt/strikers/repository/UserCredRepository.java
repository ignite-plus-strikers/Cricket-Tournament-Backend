package com.tgt.strikers.repository;

import com.tgt.strikers.model.UserCred;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserCredRepository extends CassandraRepository<UserCred,String> {
}