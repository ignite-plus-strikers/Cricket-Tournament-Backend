package com.tgt.strikers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamPlayer {

    @NotNull
    @PrimaryKey
    @Column("teamid")
    private UUID teamId;

    @NotNull
    @Column("playerid")
    private UUID playerId;

    @Column("pfirstname")
    private String playerFirstName;

    @Column("plastname")
    private String playerLastName;

    @Column("pinitials")
    private String playerInitials;

}
