package com.tgt.strikers.repository;

import com.tgt.strikers.model.UserDetail;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserDetailRepository extends CassandraRepository<UserDetail,String> {
}
