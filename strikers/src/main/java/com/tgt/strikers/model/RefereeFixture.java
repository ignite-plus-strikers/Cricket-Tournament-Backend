package com.tgt.strikers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefereeFixture {

    @PrimaryKeyColumn(name = "referee_id" , type = PrimaryKeyType.CLUSTERED)
    private UUID refereeId;

    @PrimaryKeyColumn(name="fixture_id" , type = PrimaryKeyType.PARTITIONED,ordinal = 1)
    private UUID fixtureId;

}
