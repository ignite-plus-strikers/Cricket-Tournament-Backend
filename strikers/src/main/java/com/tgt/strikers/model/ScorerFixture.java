package com.tgt.strikers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("scorer_fixture")
public class ScorerFixture {

    @PrimaryKeyColumn(name = "scorer_id" , type = PrimaryKeyType.PARTITIONED, ordinal = 0)
    private String scorerId;

    @PrimaryKeyColumn(name="fixture_id" , type = PrimaryKeyType.CLUSTERED, ordinal = 1)
    private UUID fixtureId;

}
