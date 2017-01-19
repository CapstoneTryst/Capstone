package com.codeup.api;

import org.springframework.beans.factory.annotation.Value;

public class YelpFactory {
    @Value("${yelp-consumer-key}")
    private static String CONSUMER_KEY = "dSVCGtVo4VsxeSy97PISxg";
    @Value("${yelp-consumer-secret}")
    private static String CONSUMER_SECRET = "_RPvdp4_9AVYc-i83L8D1Cvs9n4";
    @Value("${yelp-token}")
    private static String TOKEN = "MUM_VOM60HrcjEBTwfCySYiy7hBIgIh0";
    @Value("${yelp-token-secret}")
    private static String TOKEN_SECRET = "cSUGqasKMECFxe701LPcICw6GF4";

    private static Yelp yelpDao;

    public static Yelp getYelpDao() {
        if (yelpDao == null) {
            yelpDao = new Yelp(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
        }
        return yelpDao;
    }
}
