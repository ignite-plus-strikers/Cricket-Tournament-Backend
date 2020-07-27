package com.tgt.strikers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.strikers.controller.TeamController;
import com.tgt.strikers.model.Teams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TeamController.class)
public class TeamServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TeamController teamController;

    @Test
    public void getTeams() throws Exception {
        Teams team = new Teams();
        team.setTName("Team India");
        team.setTCountry("India");

        List<Teams> allTeams = singletonList(team);

        given(teamController.getAllTeams()).willReturn(allTeams);

        mvc.perform(get("/cricket-tournament/teams")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$", hasSize(1)))
        //.andExpect(jsonPath("$[0].city", is(team.ge())));
    }

    @Test
    public void createTeam() throws Exception {
        Teams team = new Teams();
        team.setTName("Team India");
        team.setTCountry("India");

        given(teamController.createTeam(team)).willReturn(team);

        mvc.perform(post("/cricket-tournament/team")
                .content(asJsonString(team))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void getTeamById() throws Exception {
        Teams team = new Teams();
        team.setTName("Team India");
        team.setTCountry("India");

        given(teamController.getTeamById(team.getTeamId())).willReturn(team);

        mvc.perform(get("/cricket-tournament/team/789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteTeamById() throws Exception {
        Teams team = new Teams();
        team.setTName("Team India");
        team.setTCountry("India");

        given(teamController.deleteTeamById(team.getTeamId())).willReturn("Team deleted");

        mvc.perform(delete("/cricket-tournament/team/789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }
    
    /*@Test
    public void updatePlayerById() throws Exception {
        Player team = new Player();
        team.setFirstName("AB de");
        team.setLastName("Villiers");
        team.setNationality("South Africa");
        team.setGender("M");
        team.setCategory("B3");
        team.setPInitials("ABD");
        team.setPlayerRole("All Rounder");
        team.setPlayerBattingStyle("Left-handed batsman");
        team.setPlayerBowlingStyle("Right handed bowler");
        team.setPlayerStatus("playing");

        given(teamController.updatePlayerById(team.getPlayerId(),team)).willReturn(team);

        mvc.perform(put("/cricket-tournament/team/f241475d-0fa4-4c17-aa82-9a92d3ebb1ce")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("city", is(arrival.getCity())));
    }*/


}
