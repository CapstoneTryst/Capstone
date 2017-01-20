package com.codeup.controllers;

import com.codeup.dao.Users;
import com.codeup.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private Users usersDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginPage() {
        return "user/login";
    }


    @GetMapping("/create")
    public String createNewUser(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/create")
    public String registerNewUser(@Valid User newUser, Errors validation, Model model){

        if (validation.hasErrors()){
            model.addAttribute("errors", validation);
            model.addAttribute("user", newUser);
            return "user/create";
        }

        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        usersDao.save(newUser);
        return "redirect:/login";
    }


}
