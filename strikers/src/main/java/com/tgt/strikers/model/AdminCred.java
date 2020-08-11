package com.tgt.strikers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.Email;

@Table("admin_credentials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminCred {

    @PrimaryKey
    private String adminEmail;

    @Column("admin_firstname")
    private String adminFirstname;

    @Column("admin_lastname")
    private String adminLastname;

    //@Column("admin_password")
    //private String adminPassword;


}