package com.tgt.strikers.repository;

import com.tgt.strikers.model.SiteAdminCred;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface SiteAdminCredRepository extends CassandraRepository<SiteAdminCred,String> {
}