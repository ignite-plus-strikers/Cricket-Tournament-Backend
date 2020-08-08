package com.tgt.strikers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.strikers.controller.FixtureController;
import com.tgt.strikers.model.Fixture;
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
@WebMvcTest(FixtureController.class)
public class FixtureServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FixtureController fixtureController;

    @Test
    public void getFixtures() throws Exception {
        Fixture fixture = new Fixture();
        fixture.setTeam1("India");
        fixture.setTeam2("England");
        fixture.setHomeTeam("England");
        fixture.setSeriesId(UUID.fromString("83870576-452a-428c-97e9-526451682e14"));
        fixture.setSeriesName("India Tour of England 2020");
        fixture.setMatchType("First-class");
        fixture.setDescription("India tour of England 2020");
        fixture.setLiveCoverage("Yes");
        fixture.setVenue("Lord's");
        fixture.setScorerId("116362528129737730570");
        fixture.setScorerName("James Mathew");
        fixture.setGmtOffset("+5:30");

        List<Fixture> allFixtures = singletonList(fixture);

        given(fixtureController.getFixtures()).willReturn(allFixtures);

        mvc.perform(get("/cricket-tournament/fixtures")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$", hasSize(1)))
        //.andExpect(jsonPath("$[0].city", is(fixture.ge())));
    }

    @Test
    public void createFixture() throws Exception {
        Fixture fixture = new Fixture();
        fixture.setTeam1("India");
        fixture.setTeam2("England");
        fixture.setHomeTeam("England");
        fixture.setSeriesId(UUID.fromString("83870576-452a-428c-97e9-526451682e14"));
        fixture.setSeriesName("India Tour of England 2020");
        fixture.setMatchType("First-class");
        fixture.setDescription("India tour of England 2020");
        fixture.setLiveCoverage("Yes");
        fixture.setVenue("Lord's");
        fixture.setScorerId("116362528129737730570");
        fixture.setScorerName("James Mathew");
        fixture.setGmtOffset("+5:30");

        given(fixtureController.createFixture(fixture)).willReturn(fixture);

        mvc.perform(post("/cricket-tournament/fixture")
                .content(asJsonString(fixture))
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
    public void getFixtureById() throws Exception {
        Fixture fixture = new Fixture();
        fixture.setTeam1("India");
        fixture.setTeam2("England");
        fixture.setHomeTeam("England");
        fixture.setSeriesId(UUID.fromString("83870576-452a-428c-97e9-526451682e14"));
        fixture.setSeriesName("India Tour of England 2020");
        fixture.setMatchType("First-class");
        fixture.setDescription("India tour of England 2020");
        fixture.setLiveCoverage("Yes");
        fixture.setVenue("Lord's");
        fixture.setScorerId("116362528129737730570");
        fixture.setScorerName("James Mathew");
        fixture.setGmtOffset("+5:30");

        given(fixtureController.getFixtureById(fixture.getFixtureId())).willReturn(fixture);

        mvc.perform(get("/cricket-tournament/fixture/ 531a0f6c-1da1-42a9-91a9-682190edde92")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteFixtureById() throws Exception {
        Fixture fixture = new Fixture();
        fixture.setTeam1("India");
        fixture.setTeam2("England");
        fixture.setHomeTeam("England");
        fixture.setSeriesId(UUID.fromString("83870576-452a-428c-97e9-526451682e14"));
        fixture.setSeriesName("India Tour of England 2020");
        fixture.setMatchType("First-class");
        fixture.setDescription("India tour of England 2020");
        fixture.setLiveCoverage("Yes");
        fixture.setVenue("Lord's");
        fixture.setScorerId("116362528129737730570");
        fixture.setScorerName("James Mathew");
        fixture.setGmtOffset("+5:30");

        given(fixtureController.deleteFixtureById(fixture.getFixtureId())).willReturn("Fixture deleted");

        mvc.perform(delete("/cricket-tournament/fixture/ 531a0f6c-1da1-42a9-91a9-682190edde92")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    /*@Test
    public void updateFixtureById() throws Exception {
        Fixture fixture = new Fixture();
        fixture.setFirstName("AB de");
        fixture.setLastName("Villiers");
        fixture.setNationality("South Africa");
        fixture.setGender("M");
        fixture.setCategory("B3");
        fixture.setPInitials("ABD");
        fixture.setFixtureRole("All Rounder");
        fixture.setFixtureBattingStyle("Left-handed batsman");
        fixture.setFixtureBowlingStyle("Right handed bowler");
        fixture.setFixtureStatus("playing");

        given(fixtureController.updateFixtureById(fixture.getFixtureId(),fixture)).willReturn(fixture);

        mvc.perform(put("/cricket-tournament/fixture/f241475d-0fa4-4c17-aa82-9a92d3ebb1ce")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("city", is(arrival.getCity())));
    }*/


}
