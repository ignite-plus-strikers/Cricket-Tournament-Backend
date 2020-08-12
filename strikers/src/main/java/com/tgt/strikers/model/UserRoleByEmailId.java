package com.tgt.strikers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;

@Data
@Table("user_role")
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleByEmailId {

    @PrimaryKey
    private String userEmailId;

    @NotNull
    @Column("user_role")
    private String userRole;
}
