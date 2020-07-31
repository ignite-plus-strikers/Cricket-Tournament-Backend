package com.tgt.strikers.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Table
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Fixture {

    @PrimaryKey
    private UUID fixtureId;

    @Column("team1")
    @NotNull
    private String team1;

    @Column("team2")
    @NotNull
    private String team2;

    @Column("home_team")
    @NotNull
    private String homeTeam;

    @NotNull
    @Column("series_id")
    private UUID seriesId;

    @NotNull
    @Column("series_name")
    private String seriesName;

    @Column("fixture_date_time")
    @NotNull
    private Date fixtureDateTime;

    @Column("match_type")
    @NotNull
    private String matchType;

    @Column("description")
    private String description;

    @NotNull
    @Column("live_coverage")
    private String liveCoverage;

    @Column("venue")
    @NotNull
    private String venue;

    @Column("scorer_id")
    @NotNull
    private UUID scorerId;

    @Column("scorer_name")
    @NotNull
    private String scorerName;

    @Column("gmt_offset")
    @NotNull
    private String gmtOffset;
}
