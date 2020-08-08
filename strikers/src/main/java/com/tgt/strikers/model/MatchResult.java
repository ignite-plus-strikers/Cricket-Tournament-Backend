package com.tgt.strikers.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.UUID;

@Table("match_result")
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MatchResult {

    @PrimaryKey
    private UUID matchId;

    @NotNull
    private String team1;

    @NotNull
    private String team2;

    @Column("match_result")
    private String matchResult;

    @Column("team1_result")
    private Map<String, Integer> team1Result;

    @Column("team2_result")
    private Map<String, Integer> team2Result;

    @Column("winning_score")
    private Map<String, Integer> winningScore;
}