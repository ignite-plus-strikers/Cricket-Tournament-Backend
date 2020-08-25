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

}