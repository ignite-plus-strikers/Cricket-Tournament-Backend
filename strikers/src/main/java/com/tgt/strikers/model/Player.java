package com.tgt.strikers.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @PrimaryKey
    private UUID playerId;

    @NotNull
    @Size(min = 3, message = "First Name must have atleast 3 characters")
    private String pFirstName;

    @NotNull
    @Size(min = 2, message = "Last Name must have atleast 2 characters")
    private String pLastName;

    @NotNull
    private String pNickName;

    @NotNull
    private String pCategory;

    @NotNull
    private String pNationality;

    @NotNull
    private String pGender;

    @NotNull
    @Past
    private LocalDate playerDob;

    @NotNull
    private String playerRole;

    @NotNull
    private String playerBowlingStyle;

    @NotNull
    private String playerBattingStyle;

    @NotNull
    private String playerStatus;

    private Integer stateTeamId;

    private Integer nationalTeamId;
}