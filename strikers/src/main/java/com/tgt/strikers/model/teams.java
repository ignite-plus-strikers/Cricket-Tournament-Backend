package com.tgt.strikers.model;

import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teams {

    @Id
    @PrimaryKey
    @Column("teamId")
    private UUID teamId;

    @NotNull
    @Column("teamname")
    private String tName;

    @Column("state")
    private String tState;

    @NotNull
    @Column("country")
    private String tCountry;
}
