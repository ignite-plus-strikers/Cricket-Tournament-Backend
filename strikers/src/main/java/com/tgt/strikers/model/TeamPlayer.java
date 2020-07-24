package com.tgt.strikers.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@Table("team_player")
public class TeamPlayer {

    @NotNull
    @PrimaryKeyColumn(name = "team_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID teamId;

    @PrimaryKeyColumn(name = "player_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID playerId;

    @Column("player_first_name")
    private String playerFirstName;

    @Column("player_last_name")
    private String playerLastName;

    @Column("player_initials")
    private String playerInitials;

}
