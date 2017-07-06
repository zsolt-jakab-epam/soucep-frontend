package com.soucep.frontend.user.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static common.Constants.HOME_NOT_SIGNED_IN;
import static common.Constants.ROOT_PATH;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@Controller
@RequestMapping(value = ROOT_PATH, consumes = {APPLICATION_FORM_URLENCODED_VALUE})
public class HomeController {

    @GetMapping()
    public String home() {
        return HOME_NOT_SIGNED_IN;
    }
}
