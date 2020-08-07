package com.tgt.strikers.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Table("pre_match")
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PreMatch {

    @PrimaryKey
    private UUID matchId;

    @NotNull
    private String team1;

    @NotNull
    private String team2;

    @NotNull
    @Column("series_name")
    private String seriesName;

    @NotNull
    @Column("match_date")
    private LocalDate matchDate;

    @Column("match_time")
    @NotNull
    private LocalTime matchTime;

    @NotNull
    private String venue;

    @NotNull
    private String toss;

    @NotNull
    @Column("toss_decision")
    private String tossDecision;

    @NotNull
    private List<String> umpires;

    @NotNull
    private String referee;

    @NotNull
    @Column("team1_playing_11")
    private List<String> team1Playing11;

    @NotNull
    @Column("team2_playing_11")
    private List<String> team2Playing11;

    @NotNull
    @Column("team1_captain_wicketkeeper")
    private Map<String, String> team1CaptainWicketKeeper;

    @NotNull
    @Column("team2_captain_wicketkeeper")
    private Map<String, String> team2CaptainWicketKeeper;


}