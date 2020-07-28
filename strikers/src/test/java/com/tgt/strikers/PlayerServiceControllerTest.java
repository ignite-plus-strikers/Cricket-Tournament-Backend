package com.tgt.strikers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.strikers.controller.PlayerController;
import com.tgt.strikers.model.Player;
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
@WebMvcTest(PlayerController.class)
public class PlayerServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PlayerController playerController;

    @Test
    public void getPlayers() throws Exception {
        Player player = new Player();
        player.setFirstName("AB de");
        player.setLastName("Villiers");
        player.setNationality("South Africa");
        player.setGender("M");
        player.setCategory("B3");
        player.setPlayerInitials("ABD");
        player.setPlayerRole("All Rounder");
        player.setPlayerBattingStyle("Right-handed batsman");
        player.setPlayerBowlingStyle("Right handed bowler");
        player.setPlayerStatus("playing");

        List<Player> allPlayers = singletonList(player);

        given(playerController.getAllPlayer()).willReturn(allPlayers);

        mvc.perform(get("/cricket-tournament/players")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$", hasSize(1)))
        //.andExpect(jsonPath("$[0].city", is(player.ge())));
    }

    @Test
    public void createPlayer() throws Exception {
        Player player = new Player();
        player.setFirstName("AB de");
        player.setLastName("Villiers");
        player.setNationality("South Africa");
        player.setGender("M");
        player.setCategory("B3");
        player.setPlayerInitials("ABD");
        player.setPlayerRole("All Rounder");
        player.setPlayerBattingStyle("Right-handed batsman");
        player.setPlayerBowlingStyle("Right handed bowler");
        player.setPlayerStatus("playing");

        given(playerController.createPlayer(player)).willReturn(player);

        mvc.perform(post("/cricket-tournament/player")
                .content(asJsonString(player))
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
    public void getPlayerById() throws Exception {
        Player player = new Player();
        player.setFirstName("AB de");
        player.setLastName("Villiers");
        player.setNationality("South Africa");
        player.setGender("M");
        player.setCategory("B3");
        player.setPlayerInitials("ABD");
        player.setPlayerRole("All Rounder");
        player.setPlayerBattingStyle("Right-handed batsman");
        player.setPlayerBowlingStyle("Right handed bowler");
        player.setPlayerStatus("playing");

        given(playerController.getPlayerById(player.getPlayerId())).willReturn(player);

        mvc.perform(get("/cricket-tournament/player/f241475d-0fa4-4c17-aa82-9a92d3ebb1ce")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void deletePlayerById() throws Exception {
        Player player = new Player();
        player.setFirstName("AB de");
        player.setLastName("Villiers");
        player.setNationality("South Africa");
        player.setGender("M");
        player.setCategory("B3");
        player.setPlayerInitials("ABD");
        player.setPlayerRole("All Rounder");
        player.setPlayerBattingStyle("Right-handed batsman");
        player.setPlayerBowlingStyle("Right handed bowler");
        player.setPlayerStatus("playing");

        given(playerController.deletePlayerById(player.getPlayerId())).willReturn("Player deleted");

        mvc.perform(delete("/cricket-tournament/player/f241475d-0fa4-4c17-aa82-9a92d3ebb1ce")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    /*@Test
    public void updatePlayerById() throws Exception {
        Player player = new Player();
        player.setFirstName("AB de");
        player.setLastName("Villiers");
        player.setNationality("South Africa");
        player.setGender("M");
        player.setCategory("B3");
        player.setPInitials("ABD");
        player.setPlayerRole("All Rounder");
        player.setPlayerBattingStyle("Left-handed batsman");
        player.setPlayerBowlingStyle("Right handed bowler");
        player.setPlayerStatus("playing");

        given(playerController.updatePlayerById(player.getPlayerId(),player)).willReturn(player);

        mvc.perform(put("/cricket-tournament/player/f241475d-0fa4-4c17-aa82-9a92d3ebb1ce")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("city", is(arrival.getCity())));
    }*/


}
