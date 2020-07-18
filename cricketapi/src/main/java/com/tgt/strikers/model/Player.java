package com.tgt.strikers.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @PrimaryKey
    private UUID playerId;

    @NotNull
    @Size(min = 3, message = "First Name must have atleast 3 characters")
    private String firstName;

    @NotNull
    @Size(min = 2, message = "Last Name must have atleast 2 characters")
    private String lastName;

    @NotNull
    private String category;

    @NotNull
    private String nationality;

    @NotNull
    private String gender;

    @NotNull
    @Past
    private LocalDate playerDOB;

    @NotNull
    private String playerRole;

    @NotNull
    private String playerBowlingStyle;

    @NotNull
    private String playerBattingStyle;

    @NotNull
    private String playerStatus;

    private UUID stateTeamId;

    private UUID nationalTeamId;

}
