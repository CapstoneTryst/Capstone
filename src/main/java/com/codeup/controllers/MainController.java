package com.codeup.controllers;

import com.codeup.dao.DateCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @Autowired
    private DateCategories categoriesDao;

    @GetMapping("/")
    public String showWelcome() {
        return "welcome";
    }

    @GetMapping("/show")
    public String show() {
        return "show";
    }



}
