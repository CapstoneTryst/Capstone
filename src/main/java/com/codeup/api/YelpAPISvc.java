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


    public JSONArray queryAPI(String term, String location) {
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
}
