package com.tgt.strikers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.strikers.controller.SeriesController;
import com.tgt.strikers.model.Series;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
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
@WebMvcTest(SeriesController.class)
public class SeriesServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SeriesController seriesController;

    @Test
    public void getSeries() throws Exception {
        Series series = new Series();
        series.setSeriesName("Champion County Match 2018");
        series.setHostCountry(Arrays.asList("WI","UNKWN"));
        series.setSeriesShortName("CCM 2018");
        series.setSeriesStartDate(LocalDate.parse("2020-11-10"));
        series.setSeriesEndDate(LocalDate.parse("2020-11-30"));
        series.setPointsTableActive(false);
        series.setSeriesPoints(0);
        series.setSeriesType("First Class");
        series.setTournament("Other First class");

        List<Series> allSeries = singletonList(series);

        given(seriesController.getAllSeries()).willReturn(allSeries);

        mvc.perform(get("/cricket-tournament/series")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$", hasSize(1)))
        //.andExpect(jsonPath("$[0].city", is(series.ge())));
    }

    @Test
    public void createSeries() throws Exception {
        Series series = new Series();
        series.setSeriesName("Champion County Match 2018");
        series.setHostCountry(Arrays.asList("WI","UNKWN"));
        series.setSeriesShortName("CCM 2018");
        series.setSeriesStartDate(LocalDate.parse("2020-11-10"));
        series.setSeriesEndDate(LocalDate.parse("2020-11-30"));
        series.setPointsTableActive(false);
        series.setSeriesPoints(0);
        series.setSeriesType("First Class");
        series.setTournament("Other First class");

        given(seriesController.createSeries(series)).willReturn(series);

        mvc.perform(post("/cricket-tournament/series")
                .content(asJsonString(series))
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
    public void getSeriesById() throws Exception {
        Series series = new Series();
        series.setSeriesName("Champion County Match 2018");
        series.setHostCountry(Arrays.asList("WI","UNKWN"));
        series.setSeriesShortName("CCM 2018");
        series.setSeriesStartDate(LocalDate.parse("2020-11-10"));
        series.setSeriesEndDate(LocalDate.parse("2020-11-30"));
        series.setPointsTableActive(false);
        series.setSeriesPoints(0);
        series.setSeriesType("First Class");
        series.setTournament("Other First class");

        given(seriesController.getSeriesById(series.getSeriesId())).willReturn(series);

        mvc.perform(get("/cricket-tournament/series/789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteSeriesById() throws Exception {
        Series series = new Series();
        series.setSeriesName("Champion County Match 2018");
        series.setHostCountry(Arrays.asList("WI","UNKWN"));
        series.setSeriesShortName("CCM 2018");
        series.setSeriesStartDate(LocalDate.parse("2020-11-10"));
        series.setSeriesEndDate(LocalDate.parse("2020-11-30"));
        series.setPointsTableActive(false);
        series.setSeriesPoints(0);
        series.setSeriesType("First Class");
        series.setTournament("Other First class");

        given(seriesController.deleteSeriesById(series.getSeriesId())).willReturn("Series deleted");

        mvc.perform(delete("/cricket-tournament/series/789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }
    
    /*@Test
    public void updatePlayerById() throws Exception {
        PSeries series = new Series();
        series.setSeriesName("Champion County Match 2018");
        series.setHostCountry(Arrays.asList("WI","UNKWN"));
        series.setSeriesShortName("CCM 2018");
        series.setSeriesStartDate(LocalDate.parse("2020-11-10"));
        series.setSeriesEndDate(LocalDate.parse("2020-11-30"));
        series.setPointsTableActive(false);
        series.setSeriesPoints(0);
        series.setSeriesType("First Class");
        series.setTournament("Other First class");

        given(seriesController.updatePlayerById(series.getPlayerId(),series)).willReturn(series);

        mvc.perform(put("/cricket-tournament/series/f241475d-0fa4-4c17-aa82-9a92d3ebb1ce")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("city", is(arrival.getCity())));
    }*/

}
