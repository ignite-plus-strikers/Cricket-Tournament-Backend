package com.tgt.strikers.repository;

import com.tgt.strikers.model.AdminCred;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface AdminCredRepository extends CassandraRepository<AdminCred,String> {
}