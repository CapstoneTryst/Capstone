# Tryst 

A user needs to find a good place to go for date night and doesnt want to scour the 
numerous Yelp and Google reviews to find one. Our site uses the Yelp API and date night
specific search parameters to do the work for the user and recommend a place to go. 

Users can review our sugestions and add new ones to our database. 

Also includes a link to Yelp's review page of the Tryst recommended location for
further inquires regarding the suggested place to go.

## Key Features 

1. Arrival at the landing page. - User can enter location by "zip code or city, St" and 
select a specific search category.

2. Tryst will recommend a location. - Tryst sends the users location to the yelp API. 
It returns a JSON array of all the "businesses and locations" in that location. Our 
database filters the results by the users selected date type and recommends a 
"business or location" based on our databases rating of that "business" for the 
selected kind of date. 

3. Tryst only displays one recommendation at a time. - This helps eliminate the the 
frustration of making choice. If the user is unhappy with the recommendation they 
can ask for another suggestion. It will return another suggestion from the array of 
JSON objects that came from the Yelp API.

4. Users can add "locations/business" to our database. - After a user has 
created a account. They can search for a specific location and add it to our 
database. They can also add recommendations for what kind of "date" that 
"business/location" is good for. 

5. If a location is searched that has no "location/business" reviews in the 
Tryst database. Tryst will randomly recommend a top Yelp.com rated "restaurant/location".

## Future Features 

1.