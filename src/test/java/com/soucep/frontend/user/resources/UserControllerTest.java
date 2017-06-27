package com.soucep.frontend.user.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;



public class UserControllerTest {

    private static MockMvc mockMvc;

    private static UserController underTest;

    @BeforeClass
    public static void setUp() {
        underTest = new UserController();
        mockMvc = standaloneSetup(underTest).build();
    }

    @Test
    public void homeReturnHomeNotSignedInViewWithStatusOk() throws Exception {

        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(view().name("home/homeNotSignedIn"));
    }

}
