package com.tgt.strikers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.Email;

@Table("scorer_credentials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScorerCred {

    @PrimaryKey
    private String scorerEmail;

    @Column("scorer_firstname")
    private String scorerFirstname;

    @Column("scorer_lastname")
    private String scorerLastname;

    //@Column("scorer_password")
    //private String scorerPassword;


}
