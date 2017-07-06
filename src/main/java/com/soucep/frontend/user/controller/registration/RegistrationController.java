package com.soucep.frontend.user.controller.registration;

import com.soucep.frontend.user.domain.UserRegistrationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static common.Constants.*;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@Controller
@RequestMapping(value = REGISTRATION, consumes = {APPLICATION_FORM_URLENCODED_VALUE})
public class RegistrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);


    @GetMapping
    public String registrationForm() {
        return REGISTRATION_FORM;
    }

    @PostMapping
    public String submitRegistration(UserRegistrationRequest userRequest) {
        LOGGER.info("A user started a registration with request: {}", userRequest);
        return REDIRECT_REGISTRATION_ACCEPTED;
    }

    @GetMapping(ACCEPTED)
    public String acceptRegistration() {
        return REGISTRATION_ACCEPTED;
    }


}
