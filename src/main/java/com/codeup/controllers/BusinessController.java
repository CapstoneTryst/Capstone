package com.codeup.controllers;

import com.codeup.dao.TrystRankings;
import com.codeup.models.DateCategory;
import com.codeup.models.TrystRanking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BusinessController extends BaseController {

    @Autowired
    private TrystRankings rankingsDao;

    @PostMapping("/business/new/{businessId}")
    public String addNewBusiness(@PathVariable String businessId) {

        TrystRanking newRanking = new TrystRanking();

        newRanking.setYelpId(businessId);
        newRanking.setUser(loggedInUser());
        rankingsDao.save(newRanking);

        return "redirect:/";
    }

    @PostMapping("/business/positive")
    @ResponseStatus(value = HttpStatus.OK)
    public void ratePositive(@RequestParam("category") int category, @RequestParam("businessId") String businessId) {
        System.out.println(category + " " + businessId);

        TrystRanking unrankedRating = rankingsDao.findByUserIdAndRatingAndYelpId(loggedInUser(), 0, businessId);

            DateCategory dateCategory = new DateCategory();
            dateCategory.setId(category);

        if (unrankedRating.getDateCategory() == null){

            TrystRanking newTrystRating = new TrystRanking();

            newTrystRating.setYelpId(businessId);
            newTrystRating.setRating(1);
            newTrystRating.setDateCategory(dateCategory);
            newTrystRating.setUser(loggedInUser());

            rankingsDao.save(newTrystRating);
        } else {

            unrankedRating.setRating(1);
            unrankedRating.setDateCategory(dateCategory);
            rankingsDao.save(unrankedRating);
        }
    }
    
    @PostMapping("/business/negative")
    @ResponseStatus(value = HttpStatus.OK)
    public void rateNegative(@RequestParam("category") int category, @RequestParam("businessId") String businessId) {
        System.out.println(category + " " + businessId);

        TrystRanking unrankedRating = rankingsDao.findByUserIdAndRatingAndYelpId(loggedInUser(), 0, businessId);

        DateCategory dateCategory = new DateCategory();
        dateCategory.setId(category);

        if (unrankedRating.getDateCategory() == null){

            TrystRanking newTrystRating = new TrystRanking();

            newTrystRating.setYelpId(businessId);
            newTrystRating.setRating(-1);
            newTrystRating.setDateCategory(dateCategory);
            newTrystRating.setUser(loggedInUser());

            rankingsDao.save(newTrystRating);
        } else {

            unrankedRating.setRating(-1);
            unrankedRating.setDateCategory(dateCategory);
            rankingsDao.save(unrankedRating);
        }
    }
}
