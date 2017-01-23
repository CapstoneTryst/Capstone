package com.codeup.controllers;

import com.codeup.api.YelpAPISvc;
import com.codeup.dao.TrystRankings;
import com.codeup.dao.Users;
import com.codeup.models.TrystRanking;
import com.codeup.models.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController extends BaseController {

    @Autowired
    private Users usersDao;

    @Autowired
    private TrystRankings rankingsDao;

    @Autowired
    YelpAPISvc yelpAPI;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/user/login")
    public String showLoginPage() {
        return "user/login";
    }


    @GetMapping("/user/create")
    public String createNewUser(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/user/create")
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

    @GetMapping("/user/unrated")
    public @ResponseBody List<JSONObject> showBusinessesToRate() {
        List<TrystRanking> allBusinessesByUser = rankingsDao.findByUser(loggedInUser());
        List<TrystRanking> unratedBusinesses = new ArrayList<>();
        for(TrystRanking ranking : allBusinessesByUser) {
            if (ranking.getRating() == 0) {
                unratedBusinesses.add(ranking);
            }
        }
        List<JSONObject> toBeRated = new ArrayList<>();
        JSONObject toAdd;
        for(TrystRanking ranking : unratedBusinesses) {
            toAdd = yelpAPI.queryAPIByBusinessId(ranking.getYelpId());
            toBeRated.add(toAdd);
        }


        return toBeRated;
    }

    @GetMapping("/test")
    public @ResponseBody TrystRanking test() {
        System.out.println(rankingsDao.findOne(17L));
        return rankingsDao.findOne(17L);
    }

    @GetMapping("/user/rate")
    public String showRatePage(Model model) {
        return "user_rate_page";
    }


}
