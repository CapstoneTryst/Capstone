package com.codeup.controllers;

import com.codeup.dao.TrystRankings;
import com.codeup.models.TrystRanking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BusinessController extends BaseController {

    @Autowired
    TrystRankings rankingsDao;

    @PostMapping("/business/new/{businessId}")
    public String addNewBusiness(@PathVariable String businessId) {

        TrystRanking newRanking = new TrystRanking();

        newRanking.setYelpId(businessId);
        newRanking.setUser(loggedInUser());
        rankingsDao.save(newRanking);

        return "redirect:/";
    }
}
