package com.tgt.strikers.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Table("batsman_by_match")
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BatsmanByMatch {

    @PrimaryKeyColumn(name = "match_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID matchId;

    @PrimaryKeyColumn(name = "batsman_name", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private String batsmanName;

    @Column("team_name")
    @NotNull
    private String teamName;

    private Integer runs;

    private Integer balls;

    @Column("strike_rate")
    private Float strikeRate;

    private Integer fours;

    private Integer sixes;

    @Column("out_by")
    private String outBy;
}