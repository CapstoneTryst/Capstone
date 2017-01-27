package com.codeup.controllers;

import com.codeup.api.YelpAPISvc;
import com.codeup.dao.DateCategories;
import com.codeup.dao.TrystRankings;
import com.codeup.models.DateCategory;
import com.codeup.models.TrystRanking;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    YelpAPISvc yelpAPI;

    @Autowired
    TrystRankings rankingsDao;

    @Autowired
    DateCategories categoriesDao;

    @GetMapping("/")
    public String showWelcome(Model model) {
        List<DateCategory> categories = categoriesDao.findAll();
        model.addAttribute("categories", categories);
        return "welcome";
    }

//    @GetMapping("/show")
//    public @ResponseBody JSONObject showPage(@RequestParam(name = "location") String location, Model model) {
//        System.out.println(rankingsDao.countByYelpIdAndDateCategoryIdAndRating("local-coffee-san-antonio-3", 7, 1));
//        JSONArray allBusinesses = yelpAPI.queryAPIByLocation("", location);
//        int random = (int) Math.floor(Math.random() * allBusinesses.size());
//        return (JSONObject) allBusinesses.get(random);
//    }

    @GetMapping("/show")
    public @ResponseBody JSONObject showPage(@RequestParam(name = "location") String location, @RequestParam(name = "category") long category) {
        String searchTerm = getSearchTerm(category);
        JSONArray allInArea = yelpAPI.queryAPIByLocation(searchTerm, location);
        List<TrystRanking> allEntrysForSelectedCategory = rankingsDao.findAllByDateCategory(categoriesDao.findOne(category));
        JSONObject selectedResult;
        JSONArray allInAreaAlsoInDatabase = new JSONArray();
        int indexOfSelectedResult;
        int indexOfPositiveResult;
        JSONObject objectToGetCountOf;
        List<Integer> listToChooseFrom = new ArrayList<>();
        JSONObject objectToGetValueFrom;

        System.out.println("yelp retrieval size = " + allInArea.size());
        System.out.println("allEntrysForCategory size = " + allEntrysForSelectedCategory.size());
        for (int i = 0; i < allInArea.size(); i++) {
            System.out.println("inside of the first for loop");
            objectToGetValueFrom = (JSONObject) allInArea.get(i);
            System.out.println("object that is being worked on from the yelp api id = " + objectToGetValueFrom.get("id"));
            for (TrystRanking individualRow : allEntrysForSelectedCategory) {
                System.out.println("our databases yelp id = " + individualRow.getYelpId());
                if (objectToGetValueFrom.get("id").equals(individualRow.getYelpId())) {
                    System.out.println("now inside of the if statement... the yelp id and database yelp id are equal");
                    allInAreaAlsoInDatabase.add(objectToGetValueFrom);
                    break;
                }
            }
        }
        System.out.println("allInAreaAlso size = " + allInAreaAlsoInDatabase.size());
        for (int i = 0; i < allInAreaAlsoInDatabase.size(); i++) {
            objectToGetCountOf = (JSONObject) allInAreaAlsoInDatabase.get(i);
            System.out.println("getting positive responses for category");
            long positiveResponses = rankingsDao.countByYelpIdAndDateCategoryIdAndRating((String) objectToGetCountOf.get("id") ,category, 1);
            System.out.println("positive responses = " + positiveResponses);
            System.out.println("getting negative responses for category");
            long negativeResponses = rankingsDao.countByYelpIdAndDateCategoryIdAndRating((String) objectToGetCountOf.get("id") ,category, -1);
            System.out.println("negative responses = " + negativeResponses);
            int mathDoneGood = (int) (positiveResponses / (positiveResponses + negativeResponses)) * 100;
            if (mathDoneGood >= 60) {
                indexOfPositiveResult = i;
                for (int j = 0; j < mathDoneGood; j++) {
                    listToChooseFrom.add(indexOfPositiveResult);
                }
            }
        }
        System.out.println("listToChooseFrom.size = " + listToChooseFrom.size());
        System.out.println("getting index of selected result...");
        indexOfSelectedResult = listToChooseFrom.get((int) Math.floor(Math.random() * listToChooseFrom.size()) + 1);
        System.out.println("index of selected result is " + indexOfSelectedResult);
        selectedResult = (JSONObject) allInAreaAlsoInDatabase.get(indexOfSelectedResult);
        return selectedResult;
    }

    @GetMapping("/business/new")
    public String getBusinessAddPage() {
        return "business_search";
    }

    @GetMapping("/business")
    public @ResponseBody JSONArray getSpecificBusinesses(@RequestParam(name= "name") String term, @RequestParam(name = "location") String location, Model model) {
        JSONArray allBusinesses = yelpAPI.queryAPIByLocation(term, location);
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
    @GetMapping("/contact")
    public String getContactPage(){
        return "contact";
    }

    private String getSearchTerm(long category) {
        String searchTerm = "";
        int categoryInt = (int) category;
        switch (categoryInt) {
            case 3: searchTerm = "outdoors";
                break;
            case 4: searchTerm = "sight seeing";
                break;
            case 8: searchTerm = "art";
                break;
            case 9: searchTerm = "live music";
                break;
            default: searchTerm = "";
                break;
        }

        return searchTerm;
    }
}
