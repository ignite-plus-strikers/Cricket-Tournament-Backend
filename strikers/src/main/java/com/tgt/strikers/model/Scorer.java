package com.tgt.strikers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Scorer {

    @PrimaryKey
    private String scorerId;

    @NotNull
    @Column("first_name")
    private String firstName;

    @NotNull
    @Column("middle_name")
    private String middleName;

    @NotNull
    @Column("last_name")
    private String lastName;

    @NotNull
    private String nationality;
}
