package com.codeup.controllers;

import com.codeup.api.YelpAPISvc;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    YelpAPISvc yelpAPI;

    @GetMapping("/")
    public String showWelcome() {
        return "test";
    }

    @GetMapping("/show")
    public @ResponseBody JSONObject showPage(@RequestParam(name = "location") String location, Model model) {
        JSONArray allBusinesses = yelpAPI.queryAPI("", location);
        int random = (int) Math.floor(Math.random() * allBusinesses.size());
        return (JSONObject) allBusinesses.get(random);
    }

    @GetMapping("/business/new")
    public String getBusinessAddPage() {
        return "business_search";
    }

    @GetMapping("/business")
    public @ResponseBody JSONArray getSpecificBusinesses(@RequestParam(name= "name") String term, @RequestParam(name = "location") String location, Model model) {
        JSONArray allBusinesses = yelpAPI.queryAPI(term, location);
        JSONArray topOptions = new JSONArray();
        topOptions.add(allBusinesses.get(0));
        topOptions.add(allBusinesses.get(1));
        topOptions.add(allBusinesses.get(2));
        return topOptions;
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
