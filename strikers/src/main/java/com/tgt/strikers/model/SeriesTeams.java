package com.tgt.strikers.model;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@Table("series_teams")
public class SeriesTeams {

    @PrimaryKeyColumn(name = "series_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID seriesId;

    @PrimaryKeyColumn(name = "team_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID teamId;

    @NotNull
    @Column("team_name")
    private String teamName;

}