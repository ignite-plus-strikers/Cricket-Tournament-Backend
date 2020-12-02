package com.tgt.strikers.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Table("bowler_by_match")
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BowlerByMatch {

    @PrimaryKeyColumn(name = "match_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID matchId;


    @PrimaryKeyColumn(name = "bowler_name", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private String bowlerName;

    @Column("team_name")
    @NotNull
    private String teamName;

    private String overs;

    @Column("maiden_overs")
    private Integer maidenOvers;

    private Integer runs;

    private Integer wickets;
}