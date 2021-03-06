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

        mvc.perform(get("/cricket-tournament/site-admin-creds")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void createUserCred() throws Exception {
        SiteAdminCred siteadmin = new SiteAdminCred();
        siteadmin.setSiteAdminEmail("sitejusttotesting098@gmail.com");
        siteadmin.setSiteAdminFirstname("Percy");
        siteadmin.setSiteAdminLastname("Jackson");

        given(siteAdminCredController.createUserCred(siteadmin)).willReturn(String.valueOf(siteadmin));

        mvc.perform(post("/cricket-tournament/site-admin-cred")
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

}