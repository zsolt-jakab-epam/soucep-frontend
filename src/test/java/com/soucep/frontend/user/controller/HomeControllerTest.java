package com.soucep.frontend.user.controller;

import com.soucep.frontend.user.controller.home.HomeController;
import com.soucep.frontend.user.exception.handler.ExceptionController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static common.Constants.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest({HomeController.class, ExceptionController.class})
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void home_Should_ReturnHomeNotSignedInView_WithStatusOk_When_ContentTypeIsOk() throws Exception {

        mockMvc.perform(get(ROOT_PATH).contentType(MediaType.APPLICATION_FORM_URLENCODED))
            .andExpect(status().isOk())
            .andExpect(view().name(HOME_NOT_SIGNED_IN));
    }

    @Test
    public void home_Should_ReturnHomeNotSignedInView_WithStatusOk_When_ContentTypeIsNotOk() throws Exception {

        mockMvc.perform(get(ROOT_PATH).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isUnsupportedMediaType())
                .andExpect(view().name(ERROR_UNSUPPORTED_MEDIA_TYPE));
    }
}
