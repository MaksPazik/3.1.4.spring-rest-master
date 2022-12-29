package ru.maxpaz.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    private static final String REDIRECT_TO_LOGIN_PAGE = "redirect:/login";

    @GetMapping(value = "/")
    public String getRedirectToUserPage() {
        return REDIRECT_TO_LOGIN_PAGE;
    }
}
