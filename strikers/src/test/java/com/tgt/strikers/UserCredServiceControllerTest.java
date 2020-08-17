package com.tgt.strikers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.strikers.controller.UserCredController;
import com.tgt.strikers.model.UserCred;
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
@WebMvcTest(UserCredController.class)
public class UserCredServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserCredController userCredController;

    @Test
    public void getUserCreds() throws Exception {
        UserCred user = new UserCred();
        user.setUserEmail("caroltestingmarvel@gmail.com");
        user.setUserFirstname("Carol");
        user.setUserLastname("Marvel");

        List<UserCred> allUserCreds = singletonList(user);

        given(userCredController.getAllUserCred()).willReturn(allUserCreds);

        mvc.perform(get("/cricket-tournament/user-creds")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$", hasSize(1)))
        //.andExpect(jsonPath("$[0].city", is(fixture.ge())));
    }

    @Test
    public void createUserCred() throws Exception {
        UserCred user = new UserCred();
        user.setUserEmail("caroltestingmarvel@gmail.com");
        user.setUserFirstname("Carol");
        user.setUserLastname("Marvel");


        given(userCredController.createUserCred(user)).willReturn(String.valueOf(user));

        mvc.perform(post("/cricket-tournament/user-cred")
                .content(asJsonString(user))
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
        UserCred user = new UserCred();
        user.setUserEmail("caroltestingmarvel@gmail.com");
        user.setUserFirstname("Carol");
        user.setUserLastname("Marvel");

        given(fixtureController.getUserCredById(fixture.getUserCredId())).willReturn(fixture);

        mvc.perform(get("/cricket-tournament/fixture/ 531a0f6c-1da1-42a9-91a9-682190edde92")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteUserCredById() throws Exception {
        UserCred user = new UserCred();
        user.setUserEmail("caroltestingmarvel@gmail.com");
        user.setUserFirstname("Carol");
        user.setUserLastname("Marvel");
        given(fixtureController.deleteUserCredById(fixture.getUserCredId())).willReturn("UserCred deleted");

        mvc.perform(delete("/cricket-tournament/fixture/ 531a0f6c-1da1-42a9-91a9-682190edde92")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    } */

    /*@Test
    public void updateUserCredById() throws Exception {
        UUserCred user = new UserCred();
        user.setUserEmail("caroltestingmarvel@gmail.com");
        user.setUserFirstname("Carol");
        user.setUserLastname("Marvel");

        given(fixtureController.updateUserCredById(fixture.getUserCredId(),fixture)).willReturn(fixture);

        mvc.perform(put("/cricket-tournament/fixture/f241475d-0fa4-4c17-aa82-9a92d3ebb1ce")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("city", is(arrival.getCity())));
    }*/


}