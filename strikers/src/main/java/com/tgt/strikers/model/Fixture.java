package com.tgt.strikers.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fixture {

    @Column("fixture_id")
    @PrimaryKey
    private UUID fixture_id;

    @Column("team1")
    @NotNull
    private String team1;

    @Column("team2")
    @NotNull
    private String team2;


    @Column("home_team")
    @NotNull
    private String home_team;

    @NotNull
    @Column("series_id")
    private UUID series_id;

    @NotNull
    @Column("series_name")
    private String series_name;

    @Column("fixture_date_time")
    @NotNull
    private Date fixture_date_time;

    @Column("match_type")
    @NotNull
    private String match_type;

    @Column("description")
    private String description;

    @NotNull
    @Column("live_coverage")
    private String live_coverage;

    @Column("venue")
    @NotNull
    private String venue;

    @Column("scorer_id")
    @NotNull
    private UUID scorer_id;

    @Column("gmt_offset")
    @NotNull
    private String gmt_offset;
}
