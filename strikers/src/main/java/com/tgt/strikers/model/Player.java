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
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@Table
public class Player {

    @PrimaryKey
    private UUID playerId;

    @NotNull
    @Size(min = 3, message = "First Name must have atleast 3 characters")
    @Column("first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, message = "Last Name must have atleast 2 characters")
    @Column("last_name")
    private String lastName;

//    @NotNull
    @Column("player_initials")
    private String playerInitials;

    @NotNull
    private String category;

    @NotNull
    private String nationality;

    @NotNull
    private String gender;

    @Past
    @Column("player_dob")
    private LocalDate playerDOB;

    @NotNull
    @Column("player_role")
    private String playerRole;

    @NotNull
    @Column("player_bowling_style")
    private String playerBowlingStyle;

    @NotNull
    @Column("player_batting_style")
    private String playerBattingStyle;

    @NotNull
    @Column("player_status")
    private String playerStatus;

    private UUID stateTeamId;

    private UUID nationalTeamId;

}
