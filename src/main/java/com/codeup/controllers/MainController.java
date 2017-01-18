package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showWelcome() {
        return "welcome";
    }
}
