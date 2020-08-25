package com.tgt.strikers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.strikers.controller.UmpireController;
import com.tgt.strikers.model.Umpire;
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
@WebMvcTest(UmpireController.class)
public class UmpireServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UmpireController umpireController;

    @Test
    public void getUmpire() throws Exception {
        Umpire umpire = new Umpire();
        umpire.setFirstName("James");
        umpire.setMiddleName("J");
        umpire.setLastName("Jordan");
        umpire.setCity("London");
        umpire.setNationality("UK");
        umpire.setAccuracyPercentage(75);
        umpire.setMatchesUmpired(102);


        List<Umpire> allUmpire = singletonList(umpire);

        given(umpireController.getAllUmpire()).willReturn(allUmpire);

        mvc.perform(get("/cricket-tournament/umpires")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void createUmpire() throws Exception {
        Umpire umpire = new Umpire();
        umpire.setFirstName("James");
        umpire.setMiddleName("JB");
        umpire.setLastName("Jordan");
        umpire.setCity("London");
        umpire.setNationality("UK");
        umpire.setAccuracyPercentage(75);
        umpire.setMatchesUmpired(102);
        given(umpireController.createUmpire(umpire)).willReturn(umpire);

        mvc.perform(post("/cricket-tournament/umpire")
                .content(asJsonString(umpire))
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
    public void getUmpireById() throws Exception {
        Umpire umpire = new Umpire();
        umpire.setFirstName("James");
        umpire.setMiddleName("JB");
        umpire.setLastName("Jordan");
        umpire.setCity("London");
        umpire.setNationality("UK");
        umpire.setAccuracyPercentage(75);
        umpire.setMatchesUmpired(102);

        given(umpireController.getUmpireById(umpire.getUmpireId())).willReturn(umpire);

        mvc.perform(get("/cricket-tournament/umpire/789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteUmpireById() throws Exception {
        Umpire umpire = new Umpire();
        umpire.setFirstName("James");
        umpire.setMiddleName("JB");
        umpire.setLastName("Jordan");
        umpire.setCity("London");
        umpire.setNationality("UK");
        umpire.setAccuracyPercentage(75);
        umpire.setMatchesUmpired(102);

        given(umpireController.deleteUmpireById(umpire.getUmpireId(),umpire)).willReturn("Umpire deleted");

        mvc.perform(delete("/cricket-tournament/umpire/789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }
    
   

}
