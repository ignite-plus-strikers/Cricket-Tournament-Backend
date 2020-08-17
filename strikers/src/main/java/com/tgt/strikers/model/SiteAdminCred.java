package com.tgt.strikers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.Email;

@Table("site_admin_credentials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SiteAdminCred {

    @PrimaryKey
    private String siteAdminEmail;

    @Column("site_admin_firstname")
    private String siteAdminFirstname;

    @Column("site_admin_lastname")
    private String siteAdminLastname;

}