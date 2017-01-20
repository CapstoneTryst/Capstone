package com.codeup.api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

    Yelp yelpAPI = YelpFactory.getYelpDao();

    public JSONArray queryAPI(String location) {
        String searchResponseJSON =
                yelpAPI.searchForBusinessesByLocation("", location);

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
//        System.out.println(String.format(
//                "%s businesses found, querying business info for the top result \"%s\" ...",
//                businesses.size(), firstBusinessID));
//
//        // Select the first business and display business details
//        String businessResponseJSON = yelpApi.searchByBusinessId(firstBusinessID.toString());
//        System.out.println(String.format("Result for business \"%s\" found:", firstBusinessID));
//        System.out.println(businessResponseJSON);
    }
}
