package com.tgt.strikers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.strikers.controller.ScorerCredController;
import com.tgt.strikers.model.ScorerCred;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ScorerCredController.class)
public class ScorerCredServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ScorerCredController scorerCredController;

    @Test
    public void getScorerCreds() throws Exception {
        ScorerCred scorer = new ScorerCred();
        scorer.setScorerEmail("justtotesting098@gmail.com");
        scorer.setScorerLastname("Harry");
        scorer.setScorerLastname("Potter");

        List<ScorerCred> allScorerCreds = singletonList(scorer);

        given(scorerCredController.getAllScorerCred()).willReturn(allScorerCreds);

        mvc.perform(get("/cricket-tournament/scorer-creds")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$", hasSize(1)))
        //.andExpect(jsonPath("$[0].city", is(fixture.ge())));
    }

    @Test
    public void createScorerCred() throws Exception {
        ScorerCred scorer = new ScorerCred();
        scorer.setScorerEmail("justtotesting098@gmail.com");
        scorer.setScorerFirstname("Harry");
        scorer.setScorerLastname("Potter");

        given(scorerCredController.createScorerCred(scorer)).willReturn(String.valueOf(scorer));

        mvc.perform(post("/cricket-tournament/scorer-cred")
                .content(asJsonString(scorer))
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
    /*@Test
    public void getScorerCredById() throws Exception {
        ScorerCred scorer = new ScorerCred();
        scorer.setScorerEmail("justtotesting098@gmail.com");
        scorer.setScorerFirstname("Harry");
        scorer.setScorerLastname("Potter");


        given(fixtureController.getScorerCredById(fixture.getScorerCredId())).willReturn(fixture);

        mvc.perform(get("/cricket-tournament/fixture/ 531a0f6c-1da1-42a9-91a9-682190edde92")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteScorerCredById() throws Exception {
        ScorerCred scorer = new ScorerCred();
        scorer.setScorerEmail("justtotesting098@gmail.com");
        scorer.setScorerFirstname("Harry");
        scorer.setScorerLastname("Potter");


        given(fixtureController.deleteScorerCredById(fixture.getScorerCredId())).willReturn("ScorerCred deleted");

        mvc.perform(delete("/cricket-tournament/fixture/ 531a0f6c-1da1-42a9-91a9-682190edde92")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    } */

    /*@Test
    public void updateScorerCredById() throws Exception {
        ScorerCred scorer = new ScorerCred();
        scorer.setScorerEmail("justtotesting098@gmail.com");
        scorer.setScorerFirstname("Harry");
        scorer.setScorerLastname("Potter");

        given(fixtureController.updateScorerCredById(fixture.getScorerCredId(),fixture)).willReturn(fixture);

        mvc.perform(put("/cricket-tournament/fixture/f241475d-0fa4-4c17-aa82-9a92d3ebb1ce")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("city", is(arrival.getCity())));
    }*/


}