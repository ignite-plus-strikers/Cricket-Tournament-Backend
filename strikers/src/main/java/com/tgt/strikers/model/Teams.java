package com.tgt.strikers.model;

import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teams {

    @PrimaryKey
    private UUID teamId;

    @NotNull
    private String tName;

    private String tState;

    @NotNull
    private String tCountry;
}
