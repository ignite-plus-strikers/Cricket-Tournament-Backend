package com.tgt.strikers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.strikers.controller.TeamPlayerController;
import com.tgt.strikers.model.TeamPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

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
@WebMvcTest(TeamPlayerController.class)
public class TeamPlayerServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TeamPlayerController teamPlayerController;

    @Test
    public void getTeamPlayers() throws Exception {
        TeamPlayer teamPlayer = new TeamPlayer();
        teamPlayer.setTeamId(UUID.fromString("789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5"));
        teamPlayer.setPlayerId(UUID.fromString("ba87d514-c398-4173-af36-5d08dac1b5bb"));
        teamPlayer.setTeamName("Team India");
        teamPlayer.setPlayerFirstName("Mahendra");
        teamPlayer.setPlayerLastName("Singh Dhoni");
        teamPlayer.setPlayerInitials("MSD");

        List<TeamPlayer> allTeamPlayers = singletonList(teamPlayer);

        given(teamPlayerController.getAllTeamPlayers()).willReturn(allTeamPlayers);

        mvc.perform(get("/cricket-tournament/teamplayers")
                .contentType(APPLICATION_JSON))
               .andExpect(status().isOk());

    }

    @Test
    public void createTeamPlayer() throws Exception {
        TeamPlayer teamPlayer = new TeamPlayer();
        teamPlayer.setTeamId(UUID.fromString("789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5"));
        teamPlayer.setPlayerId(UUID.fromString("ba87d514-c398-4173-af36-5d08dac1b5bb"));
        teamPlayer.setTeamName("Team India");
        teamPlayer.setPlayerFirstName("Mahendra");
        teamPlayer.setPlayerLastName("Singh Dhoni");
        teamPlayer.setPlayerInitials("MSD");
        given(teamPlayerController.createTeamPlayer(teamPlayer)).willReturn(teamPlayer);

        mvc.perform(post("/cricket-tournament/teamplayer")
                .content(asJsonString(teamPlayer))
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
    public void getTeamPlayerById() throws Exception {
        TeamPlayer teamPlayer = new TeamPlayer();
        teamPlayer.setTeamId(UUID.fromString("789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5"));
        teamPlayer.setPlayerId(UUID.fromString("ba87d514-c398-4173-af36-5d08dac1b5bb"));
        teamPlayer.setTeamName("Team India");
        teamPlayer.setPlayerFirstName("Mahendra");
        teamPlayer.setPlayerLastName("Singh Dhoni");
        teamPlayer.setPlayerInitials("MSD");

        given(teamPlayerController.getTeamPlayerById(teamPlayer.getPlayerId())).willReturn((List<TeamPlayer>) teamPlayer);

        mvc.perform(get("/cricket-tournament/teamplayer/789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteTeamPlayerById() throws Exception {
        TeamPlayer teamPlayer = new TeamPlayer();
        teamPlayer.setTeamId(UUID.fromString("789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5"));
        teamPlayer.setPlayerId(UUID.fromString("ba87d514-c398-4173-af36-5d08dac1b5bb"));
        teamPlayer.setTeamName("Team India");
        teamPlayer.setPlayerFirstName("Mahendra");
        teamPlayer.setPlayerLastName("Singh Dhoni");
        teamPlayer.setPlayerInitials("MSD");

        given(teamPlayerController.deleteTeamPlayerById(teamPlayer.getTeamId())).willReturn("TeamPlayer deleted");

        mvc.perform(delete("/cricket-tournament/teamplayer/789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }




}
