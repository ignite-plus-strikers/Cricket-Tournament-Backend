package com.tgt.strikers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.strikers.controller.AdminCredController;
import com.tgt.strikers.model.AdminCred;
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
@WebMvcTest(AdminCredController.class)
public class AdminCredServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AdminCredController adminCredController;

    @Test
    public void getAdminCreds() throws Exception {
        AdminCred admin = new AdminCred();
        admin.setAdminEmail("caroltestingmarvel@gmail.com");
        admin.setAdminFirstname("Carol");
        admin.setAdminLastname("Marvel");

        List<AdminCred> allAdminCreds = singletonList(admin);

        given(adminCredController.getAllAdminCred()).willReturn(allAdminCreds);

        mvc.perform(get("/cricket-tournament/admin-creds")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$", hasSize(1)))
        //.andExpect(jsonPath("$[0].city", is(fixture.ge())));
    }

    @Test
    public void createAdminCred() throws Exception {
        AdminCred admin = new AdminCred();
        admin.setAdminEmail("caroltestingmarvel@gmail.com");
        admin.setAdminFirstname("Carol");
        admin.setAdminLastname("Marvel");

        given(adminCredController.createAdminCred(admin)).willReturn(String.valueOf(admin));

        mvc.perform(post("/cricket-tournament/admin-cred")
                .content(asJsonString(admin))
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
    public void getAdminCredById() throws Exception {
        AdminCred admin = new AdminCred();
        admin.setAdminEmail("caroltestingmarvel@gmail.com");
        admin.setAdminFirstname("Carol");
        admin.setAdminLastname("Marvel");

        given(fixtureController.getAdminCredById(fixture.getAdminCredId())).willReturn(fixture);

        mvc.perform(get("/cricket-tournament/fixture/ 531a0f6c-1da1-42a9-91a9-682190edde92")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteAdminCredById() throws Exception {
        AdminCred admin = new AdminCred();
        admin.setAdminEmail("caroltestingmarvel@gmail.com");
        admin.setAdminFirstname("Carol");
        admin.setAdminLastname("Marvel");

        given(fixtureController.deleteAdminCredById(fixture.getAdminCredId())).willReturn("AdminCred deleted");

        mvc.perform(delete("/cricket-tournament/fixture/ 531a0f6c-1da1-42a9-91a9-682190edde92")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    } */

    /*@Test
    public void updateAdminCredById() throws Exception {
       AdminCred admin = new AdminCred();
        admin.setAdminEmail("caroltestingmarvel@gmail.com");
        admin.setAdminFirstname("Carol");
        admin.setAdminLastname("Marvel");

        given(fixtureController.updateAdminCredById(fixture.getAdminCredId(),fixture)).willReturn(fixture);

        mvc.perform(put("/cricket-tournament/fixture/f241475d-0fa4-4c17-aa82-9a92d3ebb1ce")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("city", is(arrival.getCity())));
    }*/


}
