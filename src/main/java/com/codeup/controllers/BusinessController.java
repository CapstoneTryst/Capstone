package com.codeup.controllers;

import com.codeup.dao.DateCategories;
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

    @Autowired
    private DateCategories dateCategoriesDao;



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
    public void ratePositive(@RequestParam("category") long category, @RequestParam("businessId") String businessId) {
        System.out.println(category + " " + businessId);
        System.out.println(rankingsDao.findByUserIdAndRatingAndYelpId(loggedInUser().getId(), 0, businessId));

        TrystRanking unrankedRating = rankingsDao.findByUserIdAndRatingAndYelpId(loggedInUser().getId(), 0, businessId);

//        if (unrankedRating == null){
//            unrankedRating = rankingsDao.findByUserIdAndDateCategoryIdAndYelpId(loggedInUser().getId(), category, businessId);
//        }

        DateCategory dateCategory = dateCategoriesDao.findOne(category);
        System.out.println(dateCategory);

        if (unrankedRating == null){
            System.out.println("get unrankedRating == null");

            TrystRanking newTrystRating = new TrystRanking();

            newTrystRating.setYelpId(businessId);
            newTrystRating.setRating(1);
            newTrystRating.setDateCategory(dateCategory);
            newTrystRating.setUser(loggedInUser());

            rankingsDao.save(newTrystRating);
        } else {
            System.out.println("get unrankedRating != null");

            unrankedRating.setRating(1);
            unrankedRating.setDateCategory(dateCategory);
            rankingsDao.save(unrankedRating);
        }
    }

    @PostMapping("/business/negative")
    @ResponseStatus(value = HttpStatus.OK)
    public void rateNegative(@RequestParam("category") long category, @RequestParam("businessId") String businessId) {
        System.out.println(category + " " + businessId);
        System.out.println(rankingsDao.findByUserIdAndRatingAndYelpId(loggedInUser().getId(), 0, businessId));

        TrystRanking unrankedRating = rankingsDao.findByUserIdAndRatingAndYelpId(loggedInUser().getId(), 0, businessId);
        DateCategory dateCategory = dateCategoriesDao.findOne(category);

        System.out.println(dateCategory);

        if (unrankedRating == null) {
            System.out.println("get unrankedRating == null");

            TrystRanking newTrystRating = new TrystRanking();

            newTrystRating.setYelpId(businessId);
            newTrystRating.setRating(-1);
            newTrystRating.setDateCategory(dateCategory);
            newTrystRating.setUser(loggedInUser());

            rankingsDao.save(newTrystRating);
        } else {
            System.out.println("get unrankedRating != null");

            unrankedRating.setRating(-1);
            unrankedRating.setDateCategory(dateCategory);
            rankingsDao.save(unrankedRating);
        }
    }
}
