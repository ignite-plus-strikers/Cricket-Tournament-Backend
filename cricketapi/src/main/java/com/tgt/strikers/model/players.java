package com.tgt.strikers.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Table
public class players {

    @PrimaryKey
    private Integer player_id;

    @NotNull
    @Size(min = 3, message = "First Name must have atleast 3 characters")
    private String p_firstname;

    @NotNull
    @Size(min = 2, message = "Last Name must have atleast 2 characters")
    private String p_lastname;

    @NotNull
    private String p_category;

    @NotNull
    private String p_nationality;

    @NotNull
    private String p_gender;

    @NotNull
    private LocalDate player_dob;

    @NotNull
    private String player_role;

    @NotNull
    private String player_bowling_style;

    @NotNull
    private String player_batting_style;

    @NotNull
    private String retired_or_playing;

    private Integer state_team_id;

    private Integer national_team_id;

    public players(Integer player_id, @NotNull @Size(min = 3, message = "First Name must have atleast 3 characters") String p_firstname, @NotNull @Size(min = 2, message = "Last Name must have atleast 2 characters") String p_lastname, @NotNull String p_category, @NotNull String p_nationality, @NotNull String p_gender, @NotNull LocalDate player_dob, @NotNull String player_role, @NotNull String player_bowling_style, @NotNull String player_batting_style, @NotNull String retired_or_playing,Integer state_team_id,Integer national_team_id) {
        this.player_id = player_id;
        this.p_firstname = p_firstname;
        this.p_lastname = p_lastname;
        this.p_category = p_category;
        this.p_nationality = p_nationality;
        this.p_gender = p_gender;
        this.player_dob = player_dob;
        this.player_role = player_role;
        this.player_bowling_style = player_bowling_style;
        this.player_batting_style = player_batting_style;
        this.retired_or_playing = retired_or_playing;
        this.state_team_id=state_team_id;
        this.national_team_id=national_team_id;
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
                ", p_dob=" + player_dob +
                ", player_role='" + player_role + '\'' +
                ", p_bowling_style='" + player_bowling_style + '\'' +
                ", p_batting_style='" + player_batting_style + '\'' +
                ", retired_or_playing='" + retired_or_playing + '\'' +
                ", state_team_id='" + state_team_id + '\'' +
                ", national_team_id'" + national_team_id + '\'' +                
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

    public LocalDate getP_dob() {
        return player_dob;
    }

    public void setP_dob(LocalDate player_dob) {
        this.player_dob = player_dob;
    }

    public String getPlayer_role() {
        return player_role;
    }

    public void setPlayer_role(String player_role) {
        this.player_role = player_role;
    }

    public String getP_bowling_style() {
        return player_bowling_style;
    }

    public void setP_bowling_style(String p_bowling_style) {
        this.player_bowling_style = p_bowling_style;
    }

    public String getP_batting_style() {
        return player_batting_style;
    }

    public void setP_batting_style(String p_batting_style) {
        this.player_batting_style = p_batting_style;
    }

    public String getRetired_or_playing() {
        return retired_or_playing;
    }

    public void setRetired_or_playing(String retired_or_playing) {
        this.retired_or_playing = retired_or_playing;
    }

    public Integer getState_team_id(){
        return state_team_id;
    }

    public void getState_team_id(Integer state_team_id){
        this.state_team_id=state_team_id;
    }

    public Integer getNational_team_id(){
        return national_team_id;
    }

    public void getNational_team_id(Integer national_team_id){
        this.national_team_id=national_team_id;
    }

}
