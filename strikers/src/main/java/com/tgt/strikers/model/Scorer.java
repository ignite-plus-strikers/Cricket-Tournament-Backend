package com.tgt.strikers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scorer {

    @PrimaryKey
    @Column("scorer_id")
    private UUID scorer_id;

    @NotNull
    private String firstname;

    @NotNull
    private String middlename;

    @NotNull
    private String lastname;

    @NotNull
    private String nationality;

}
