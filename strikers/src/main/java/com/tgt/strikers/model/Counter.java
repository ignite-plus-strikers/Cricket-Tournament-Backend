package com.tgt.strikers.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Table
public class Counter {

    @PrimaryKey
    private UUID counter_id;

    @Column("players_counter")
    @NotNull
    private Integer playersCounter;


    @Column("fixtures_counter")
    @NotNull
    private Integer fixturesCounter;


    @Column("teams_counter")
    @NotNull
    private Integer teamsCounter;


    @Column("series_counter")
    @NotNull
    private Integer seriesCounter;
}
