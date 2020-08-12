package com.tgt.strikers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.Email;

@Table("user_credentials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCred {

    @PrimaryKey
    private String userEmail;

    @Column("user_firstname")
    private String userFirstname;

    @Column("user_lastname")
    private String userLastname;

    //@Column("admin_password")
    //private String adminPassword;


}