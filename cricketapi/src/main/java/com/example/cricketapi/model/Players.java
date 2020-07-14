package com.example.cricketapi.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Table
public class Players {

    @PrimaryKey
    private Integer player_id;

    @NotNull
    @Size(min = 3, message = "First Name must have atleast 3 characters")
    private String p_firstname;

    @NotNull
    @Size(min = 3, message = "Last Name must have atleast 3 characters")
    private String p_lastname;

    @NotNull
    private String p_category;

    @NotNull
    private String p_nationality;

    @NotNull
    private String p_gender;

    @NotNull
    private Date p_dob;

    @NotNull
    private String player_role;

    @NotNull
    private String p_bowling_style;

    @NotNull
    private String p_batting_style;

    @NotNull
    private String retired_or_playing;

    public Players(Integer player_id, @NotNull @Size(min = 3, message = "First Name must have atleast 3 characters") String p_firstname, @NotNull @Size(min = 3, message = "Last Name must have atleast 3 characters") String p_lastname, @NotNull String p_category, @NotNull String p_nationality, @NotNull String p_gender, @NotNull Date p_dob, @NotNull String player_role, @NotNull String p_bowling_style, @NotNull String p_batting_style, @NotNull String retired_or_playing) {
        this.player_id = player_id;
        this.p_firstname = p_firstname;
        this.p_lastname = p_lastname;
        this.p_category = p_category;
        this.p_nationality = p_nationality;
        this.p_gender = p_gender;
        this.p_dob = p_dob;
        this.player_role = player_role;
        this.p_bowling_style = p_bowling_style;
        this.p_batting_style = p_batting_style;
        this.retired_or_playing = retired_or_playing;
    }

    @Override
    public String toString() {
        return "Player{" +
                "player_id=" + player_id +
                ", p_firstname='" + p_firstname + '\'' +
                ", p_lastname='" + p_lastname + '\'' +
                ", p_category='" + p_category + '\'' +
                ", p_nationality='" + p_nationality + '\'' +
                ", p_gender='" + p_gender + '\'' +
                ", p_dob=" + p_dob +
                ", player_role='" + player_role + '\'' +
                ", p_bowling_style='" + p_bowling_style + '\'' +
                ", p_batting_style='" + p_batting_style + '\'' +
                ", retired_or_playing='" + retired_or_playing + '\'' +
                '}';
    }

    public Integer getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Integer player_id) {
        this.player_id = player_id;
    }

    public String getP_firstname() {
        return p_firstname;
    }

    public void setP_firstname(String p_firstname) {
        this.p_firstname = p_firstname;
    }

    public String getP_lastname() {
        return p_lastname;
    }

    public void setP_lastname(String p_lastname) {
        this.p_lastname = p_lastname;
    }

    public String getP_category() {
        return p_category;
    }

    public void setP_category(String p_category) {
        this.p_category = p_category;
    }

    public String getP_nationality() {
        return p_nationality;
    }

    public void setP_nationality(String p_nationality) {
        this.p_nationality = p_nationality;
    }

    public String getP_gender() {
        return p_gender;
    }

    public void setP_gender(String p_gender) {
        this.p_gender = p_gender;
    }

    public Date getP_dob() {
        return p_dob;
    }

    public void setP_dob(Date p_dob) {
        this.p_dob = p_dob;
    }

    public String getPlayer_role() {
        return player_role;
    }

    public void setPlayer_role(String player_role) {
        this.player_role = player_role;
    }

    public String getP_bowling_style() {
        return p_bowling_style;
    }

    public void setP_bowling_style(String p_bowling_style) {
        this.p_bowling_style = p_bowling_style;
    }

    public String getP_batting_style() {
        return p_batting_style;
    }

    public void setP_batting_style(String p_batting_style) {
        this.p_batting_style = p_batting_style;
    }

    public String getRetired_or_playing() {
        return retired_or_playing;
    }

    public void setRetired_or_playing(String retired_or_playing) {
        this.retired_or_playing = retired_or_playing;
    }
}
