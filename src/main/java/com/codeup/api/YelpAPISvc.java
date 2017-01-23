package com.codeup.api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("yelpAPIService")
public class YelpAPISvc {
    @Value("${yelp-consumer-key}")
    private String consumerKey;
    @Value("${yelp-consumer-secret}")
    private String consumerSecret;
    @Value("${yelp-token}")
    private String token;
    @Value("${yelp-token-secret}")
    private String tokenSecret;

    private Yelp yelpAPI;

    @PostConstruct
    public void inti() {
        yelpAPI = new Yelp(consumerKey, consumerSecret, token, tokenSecret);
    }


    public JSONArray queryAPIByLocation(String term, String location) {
        String searchResponseJSON =
                yelpAPI.searchForBusinessesByLocation(term, location);

        JSONParser parser = new JSONParser();
        JSONObject response = null;
        try {
            response = (JSONObject) parser.parse(searchResponseJSON);
            System.out.print(response + "\n");
        } catch (ParseException pe) {
            System.out.println("Error: could not parse JSON response:");
            System.out.println(searchResponseJSON);
            System.exit(1);
        }

        JSONArray businesses = (JSONArray) response.get("businesses");
        JSONObject firstBusiness = (JSONObject) businesses.get(0);
        String firstBusinessID = firstBusiness.get("id").toString();

        return businesses;
    }

    public JSONObject queryAPIByBusinessId(String businessId) {
        String searchResponseJSON =
                yelpAPI.searchByBusinessId(businessId);

        JSONParser parser = new JSONParser();
        JSONObject response = null;
        try {
            response = (JSONObject) parser.parse(searchResponseJSON);
            System.out.println("Sucessfully parsed respnose!");
            System.out.print(response + "\n");
        } catch (ParseException pe) {
            System.out.println("Error: could not parse JSON response:");
            System.out.println(searchResponseJSON);
            System.exit(1);
        }

//        System.out.println("getting 'businesses' key...");
//        JSONArray businesses = (JSONArray) response.get("businesses");
//        System.out.println(businesses);
//        System.out.println("getting the first business...");
//        JSONObject firstBusiness = (JSONObject) businesses.get(0);
//        System.out.println("getting the first business id...");
//        String firstBusinessID = firstBusiness.get("id").toString();
//        System.out.println("found the first business id: " + firstBusinessID);
        return response;
    }
}
