package com.tgt.strikers.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@Table
public class Umpire {

    @PrimaryKey
    private UUID umpireId;

    @NotNull
    @Size(min = 3, message = "First Name must have atleast 3 characters")
    @Column("first_name")
    private String firstName;

    @Size(min = 2, message = "Middle Name must have atleast 2 characters")
    @Column("middle_name")
    private String middleName;

    @NotNull
    @Size(min = 2, message = "Last Name must have atleast 2 characters")
    @Column("last_name")
    private String lastName;

    @NotNull
    private String city;

    @NotNull
    private String nationality;

    @NotNull
    @Column("matches_umpired")
    private Integer matchesUmpired;

    @NotNull
    @Column("accuracy_percentage")
    private Integer accuracyPercentage;
}
