package com.codeup.controllers;

import com.codeup.models.DateCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showWelcome() {
        return "welcome";
    }

//    @GetMapping("/{location}/{dateType}")
//    public String showSuggestion(@PathVariable String location, @PathVariable int categoryId, Model model) {
//        List<businesses> allInRadius = yelp.search(location, radius);
//        List<Business> suggestions = new arrayList;
//        DateCategory category = categoriesDao.findById(categoryId);
//        List<Business> allWithCategory = businessDao.findWithCategory(category);
//        forEach ("business": allWithCategory){
//            forEach ("yelpBusiness": allInRadius) {
//                if(business == yelpBusiness) {
//                    suggestions.add(business);
//                }
//            }
//        }
//        Business suggestion = suggestions[Math.random(Math.floor() * suggestions.length) - 1];
//        model.addAttribute("suggestion", suggestion);
//        return "show";
//    }
}
