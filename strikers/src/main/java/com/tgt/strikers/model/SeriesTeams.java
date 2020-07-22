package com.tgt.strikers.model;


import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Table("series_teams")
@Data
public class SeriesTeams {

    @PrimaryKey
    private UUID seriesId;

    @NotNull
    @Column("team_id")
    private UUID teamId;

    @NotNull
    @Column("team_name")
    private String teamName;

}