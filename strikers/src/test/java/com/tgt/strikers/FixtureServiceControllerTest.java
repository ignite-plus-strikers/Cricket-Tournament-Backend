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

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
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
        fixture.setTeam2("Australia");
        fixture.setHomeTeam("India");
        fixture.setTeam1Id(UUID.fromString("9782ba1b-e072-4b05-a1d8-7c12942a4108"));
        fixture.setTeam2Id(UUID.fromString("934b7300-6d2f-46bf-9dbc-f167d9568759"));
        fixture.setSeriesId(UUID.fromString("83870576-452a-428c-97e9-526451682e14"));
        fixture.setFixtureDate(LocalDate.parse("2020-11-21"));
        fixture.setFixtureStartTime(LocalTime.parse("12:20:00"));
        fixture.setFixtureEndTime(LocalTime.parse("16:00:00"));
        fixture.setSeriesName("India Tour of England 2020");
        fixture.setMatchType("First-class");
        fixture.setDescription("India tour of England 2020");
        fixture.setLiveCoverage("Yes");
        fixture.setVenue("Adelaide Oval");
        fixture.setScorerId("116362528129737730570");
        fixture.setScorerName("James Mathew");
        fixture.setGmtOffset("+5:30");

        List<Fixture> allFixtures = singletonList(fixture);

        given(fixtureController.getFixtures()).willReturn(allFixtures);

        mvc.perform(get("/cricket-tournament/fixtures")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void createFixture() throws Exception {
        Fixture fixture = new Fixture();
        LocalDate fixture_date = LocalDate.parse("2020-10-11");
        fixture.setTeam1("India");
        fixture.setTeam2("Australia");
        fixture.setHomeTeam("India");
        fixture.setTeam1Id(UUID.fromString("9782ba1b-e072-4b05-a1d8-7c12942a4108"));
        fixture.setTeam2Id(UUID.fromString("934b7300-6d2f-46bf-9dbc-f167d9568759"));
        fixture.setSeriesId(UUID.fromString("83870576-452a-428c-97e9-526451682e14"));
        fixture.setFixtureDate(fixture_date);
        fixture.setFixtureStartTime(LocalTime.parse("12:20:00"));
        fixture.setFixtureEndTime(LocalTime.parse("16:00:00"));
        fixture.setSeriesName("India Tour of England 2020");
        fixture.setMatchType("First-class");
        fixture.setDescription("India tour of England 2020");
        fixture.setLiveCoverage("Yes");
        fixture.setVenue("Adelaide Oval");
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
        fixture.setTeam2("Australia");
        fixture.setHomeTeam("India");
        fixture.setTeam1Id(UUID.fromString("9782ba1b-e072-4b05-a1d8-7c12942a4108"));
        fixture.setTeam2Id(UUID.fromString("934b7300-6d2f-46bf-9dbc-f167d9568759"));
        fixture.setSeriesId(UUID.fromString("83870576-452a-428c-97e9-526451682e14"));
        fixture.setFixtureDate(LocalDate.parse("2020-11-21"));
        fixture.setFixtureStartTime(LocalTime.parse("12:20:00"));
        fixture.setFixtureEndTime(LocalTime.parse("16:00:00"));
        fixture.setSeriesName("India Tour of England 2020");
        fixture.setMatchType("First-class");
        fixture.setDescription("India tour of England 2020");
        fixture.setLiveCoverage("Yes");
        fixture.setVenue("Adelaide Oval");
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
        fixture.setTeam2("Australia");
        fixture.setHomeTeam("India");
        fixture.setTeam1Id(UUID.fromString("9782ba1b-e072-4b05-a1d8-7c12942a4108"));
        fixture.setTeam2Id(UUID.fromString("934b7300-6d2f-46bf-9dbc-f167d9568759"));
        fixture.setSeriesId(UUID.fromString("83870576-452a-428c-97e9-526451682e14"));
        fixture.setFixtureDate(LocalDate.parse("2020-11-21"));
        fixture.setFixtureStartTime(LocalTime.parse("12:20:00"));
        fixture.setFixtureEndTime(LocalTime.parse("16:00:00"));
        fixture.setSeriesName("India Tour of England 2020");
        fixture.setMatchType("First-class");
        fixture.setDescription("India tour of England 2020");
        fixture.setLiveCoverage("Yes");
        fixture.setVenue("Adelaide Oval");
        fixture.setScorerId("116362528129737730570");
        fixture.setScorerName("James Mathew");
        fixture.setGmtOffset("+5:30");

        given(fixtureController.deleteFixtureById(fixture.getFixtureId())).willReturn("Fixture deleted");

        mvc.perform(delete("/cricket-tournament/fixture/ 531a0f6c-1da1-42a9-91a9-682190edde92")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }



}
