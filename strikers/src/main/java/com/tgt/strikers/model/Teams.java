package com.tgt.strikers.model;

import java.util.UUID;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Teams {

    @PrimaryKey
    private UUID teamId;

    @NotNull
    @Column("team_name")
    private String tName;

    @Column("team_state")
    private String tState;

    @NotNull
    @Column("team_country")
    private String tCountry;
}
