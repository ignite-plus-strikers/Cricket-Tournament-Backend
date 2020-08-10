package com.tgt.strikers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.strikers.controller.RefereeController;
import com.tgt.strikers.model.Referee;
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
@WebMvcTest(RefereeController.class)
public class RefereeServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RefereeController refereeController;

    @Test
    public void getReferee() throws Exception {
        Referee referee = new Referee();
        referee.setFirstName("James");
        referee.setMiddleName("JB");
        referee.setLastName("Jordan");
        referee.setCity("London");
        referee.setNationality("UK");
        referee.setExperience("10 Years");
        referee.setMatchesRefereed(102);


        List<Referee> allReferee = singletonList(referee);

        given(refereeController.getAllReferee()).willReturn(allReferee);

        mvc.perform(get("/cricket-tournament/referees")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$", hasSize(1)))
        //.andExpect(jsonPath("$[0].city", is(referee.ge())));
    }

    @Test
    public void createReferee() throws Exception {
        Referee referee = new Referee();
        referee.setFirstName("James");
        referee.setMiddleName("JB");
        referee.setLastName("Jordan");
        referee.setCity("London");
        referee.setNationality("UK");
        referee.setExperience("10 Years");
        referee.setMatchesRefereed(102);
        given(refereeController.createReferee(referee)).willReturn(referee);

        mvc.perform(post("/cricket-tournament/referee")
                .content(asJsonString(referee))
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
    public void getRefereeById() throws Exception {
        Referee referee = new Referee();
        referee.setFirstName("James");
        referee.setMiddleName("JB");
        referee.setLastName("Jordan");
        referee.setCity("London");
        referee.setNationality("UK");
        referee.setExperience("10 Years");
        referee.setMatchesRefereed(102);

        given(refereeController.getRefereeById(referee.getRefereeId())).willReturn(referee);

        mvc.perform(get("/cricket-tournament/referee/789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteRefereeById() throws Exception {
        Referee referee = new Referee();
        referee.setFirstName("James");
        referee.setMiddleName("JB");
        referee.setLastName("Jordan");
        referee.setCity("London");
        referee.setNationality("UK");
        referee.setExperience("10 Years");
        referee.setMatchesRefereed(102);

        given(refereeController.deleteRefereeById(referee.getRefereeId(),referee)).willReturn("Referee deleted");

        mvc.perform(delete("/cricket-tournament/referee/789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }
    
    /*@Test
    public void updatePlayerById() throws Exception {
        Player referee = new Player();
        referee.setFirstName("AB de");
        referee.setLastName("Villiers");
        referee.setNationality("South Africa");
        referee.setGender("M");
        referee.setCategory("B3");
        referee.setPInitials("ABD");
        referee.setPlayerRole("All Rounder");
        referee.setPlayerBattingStyle("Left-handed batsman");
        referee.setPlayerBowlingStyle("Right handed bowler");
        referee.setPlayerStatus("playing");

        given(refereeController.updatePlayerById(referee.getPlayerId(),referee)).willReturn(referee);

        mvc.perform(put("/cricket-tournament/referee/f241475d-0fa4-4c17-aa82-9a92d3ebb1ce")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("city", is(arrival.getCity())));
    }*/


}
