package com.tgt.strikers.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {

    @PrimaryKey
    private String userId;

    @NotNull
    @Column("user_name")
    private String userName;

    @NotNull
    @Column("user_email")
    private String userEmail;
}
