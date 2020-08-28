package com.tgt.strikers.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@Table
public class Series {


    @PrimaryKey
    private UUID seriesId;


    @NotNull
    @Size(min = 3, message = "Series Name must have atleast 3 characters")
    @Column("series_name")
    private String seriesName;

    @NotNull
    @Size(min = 2, message = "Series Short Name must have atleast 2 characters")
    @Column("series_short_name")
    private String seriesShortName;


    @Column("series_start_date")
    private LocalDate seriesStartDate;


    @Column("series_end_date")
    private LocalDate seriesEndDate;

    @NotNull
    @Column("series_type")
    private String seriesType;

    @NotNull
    private String tournament;

    @NotNull
    @Column("host_country")
    private List<String> hostCountry;

    @NotNull
    @Column("points_table_active")
    private Boolean pointsTableActive;

    @NotNull
    @Column("series_points")
    private Integer seriesPoints;

}