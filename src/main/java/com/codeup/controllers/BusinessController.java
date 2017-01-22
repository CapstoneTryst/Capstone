package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BusinessController {
    @GetMapping("/business/new/{businessId}")
    public String addNewBusiness(@PathVariable String businessId) {

        return "redirect:/";
    }
}
