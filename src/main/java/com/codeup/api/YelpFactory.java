package com.codeup.api;

import org.springframework.beans.factory.annotation.Value;

public class YelpFactory {
    @Value("${yelp-consumer-key}")
    private static String CONSUMER_KEY = "";
    @Value("${yelp-consumer-secret}")
    private static String CONSUMER_SECRET = "";
    @Value("${yelp-token}")
    private static String TOKEN = "";
    @Value("${yelp-token-secret}")
    private static String TOKEN_SECRET = "";

    private static Yelp yelpDao;

    public static Yelp getYelpDao() {
        if (yelpDao == null) {
            yelpDao = new Yelp(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
        }
        return yelpDao;
    }
}
