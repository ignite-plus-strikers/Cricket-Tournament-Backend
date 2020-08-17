package com.tgt.strikers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.strikers.controller.SiteAdminCredController;
import com.tgt.strikers.model.SiteAdminCred;
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
@WebMvcTest(SiteAdminCredController.class)
public class SiteAdminCredServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SiteAdminCredController siteAdminCredController;

    @Test
    public void getUserCreds() throws Exception {
        SiteAdminCred siteadmin = new SiteAdminCred();
        siteadmin.setSiteAdminEmail("sitejusttotesting098@gmail.com");
        siteadmin.setSiteAdminFirstname("Percy");
        siteadmin.setSiteAdminLastname("Jackson");

        List<SiteAdminCred> allSiteAdminCreds = singletonList(siteadmin);

        given(siteAdminCredController.getAllUserCred()).willReturn(allSiteAdminCreds);

        mvc.perform(get("/cricket-tournament/siteadmin-creds")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$", hasSize(1)))
        //.andExpect(jsonPath("$[0].city", is(fixture.ge())));
    }

    @Test
    public void createUserCred() throws Exception {
        SiteAdminCred siteadmin = new SiteAdminCred();
        siteadmin.setSiteAdminEmail("sitejusttotesting098@gmail.com");
        siteadmin.setSiteAdminFirstname("Percy");
        siteadmin.setSiteAdminLastname("Jackson");

        given(siteAdminCredController.createUserCred(siteadmin)).willReturn(String.valueOf(siteadmin));

        mvc.perform(post("/cricket-tournament/siteadmin-cred")
                .content(asJsonString(siteadmin))
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
    public void getUserCredById() throws Exception {
        SiteAdminCred siteadmin = new SiteAdminCred();
        siteadmin.setSiteAdminEmail("sitejusttotesting098@gmail.com");
        siteadmin.setSiteAdminFirstname("Percy");
        siteadmin.setSiteAdminLastname("Jackson");

        given(fixtureController.getUserCredById(fixture.getUserCredId())).willReturn(fixture);

        mvc.perform(get("/cricket-tournament/fixture/ 531a0f6c-1da1-42a9-91a9-682190edde92")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteUserCredById() throws Exception {
        SiteAdminCred siteadmin = new SiteAdminCred();
        siteadmin.setSiteAdminEmail("sitejusttotesting098@gmail.com");
        siteadmin.setSiteAdminFirstname("Percy");
        siteadmin.setSiteAdminLastname("Jackson");
        given(fixtureController.deleteUserCredById(fixture.getUserCredId())).willReturn("UserCred deleted");

        mvc.perform(delete("/cricket-tournament/fixture/ 531a0f6c-1da1-42a9-91a9-682190edde92")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    } */

    /*@Test
    public void updateUserCredById() throws Exception {
       SiteAdminCred siteadmin = new SiteAdminCred();
        siteadmin.setSiteAdminEmail("sitejusttotesting098@gmail.com");
        siteadmin.setSiteAdminFirstname("Percy");
        siteadmin.setSiteAdminLastname("Jackson");

        given(fixtureController.updateUserCredById(fixture.getUserCredId(),fixture)).willReturn(fixture);

        mvc.perform(put("/cricket-tournament/fixture/f241475d-0fa4-4c17-aa82-9a92d3ebb1ce")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("city", is(arrival.getCity())));
    }*/


}