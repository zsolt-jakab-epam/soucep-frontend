package com.soucep.frontend.user.controller;

import com.soucep.frontend.user.controller.registration.RegistrationController;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest({RegistrationController.class, ExceptionController.class})
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registrationForm_Should_ReturnRegistrationFormView_With_StatusOk_When_ContentTypeIsOk() throws Exception {

        mockMvc.perform(get(REGISTRATION).contentType(MediaType.APPLICATION_FORM_URLENCODED))
            .andExpect(status().isOk())
            .andExpect(view().name(REGISTRATION_FORM));
    }

    @Test
    public void registrationForm_Should_ReturnErrorPage_With_StatusUnsupportedMedia_When_ContentTypeIsNotOk() throws Exception {

        mockMvc.perform(get(REGISTRATION).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isUnsupportedMediaType())
                .andExpect(view().name(ERROR_UNSUPPORTED_MEDIA_TYPE));
    }

    @Test
    public void submitRegistration_Should_RedirectToRegistrationAcceptView_With_StatusIsFound_When_ContentTypeIsOk() throws Exception {

        mockMvc.perform(post(REGISTRATION).contentType(MediaType.APPLICATION_FORM_URLENCODED))
            .andExpect(status().isFound())
            .andExpect(redirectedUrl(REGISTRATION_ACCEPTED));
    }

    @Test
    public void submitRegistration_Should_ReturnErrorView_With_StatusUnsupportedMedia_When_ContentTypeIsNotOk() throws Exception {

        mockMvc.perform(post(REGISTRATION).contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isUnsupportedMediaType())
            .andExpect(view().name(ERROR_UNSUPPORTED_MEDIA_TYPE));
    }

    @Test
    public void acceptRegistration_Should_ReturnRegistrationAcceptedView_WithStatusOk_When_ContentTypeIsOk() throws Exception {

        mockMvc.perform(get(SLASH_REGISTRATION_ACCEPTED).contentType(MediaType.APPLICATION_FORM_URLENCODED))
            .andExpect(status().isOk())
            .andExpect(view().name(REGISTRATION_ACCEPTED));
    }

    @Test
    public void acceptRegistration_Should_ReturnRegistrationAcceptedView_WithStatusOk_When_ContentTypeIsNotOk() throws Exception {

        mockMvc.perform(get(SLASH_REGISTRATION_ACCEPTED).contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isUnsupportedMediaType())
            .andExpect(view().name(ERROR_UNSUPPORTED_MEDIA_TYPE));
    }
}
