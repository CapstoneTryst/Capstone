var searchResults = "";

$(".date_type").click(function() {
   $.get("/show", {
       location: $("#location").val(),
       category: $(this).data("db-id")
   })
       .done(function(data) {
           $("#businessTitle").html(data.name);
           $("#reviewCount").html(data.review_count + " yelp reviews");
           $("#businessPhone").html(data.display_phone);
           $("#ratingImageUrl").attr("src", data.rating_img_url_large);
           $("#businessAddress").html(data.location.address[0] + "| " + data.location.city + ", " + data.location.state_code + " " + data.location.postal_code);
           $("#businessImage").attr("src", data.image_url.substring(0, data.image_url.length - 6) + "ls.jpg");
           $("#yelpUrl").attr("href", data.url).html("See More about \"" + data.name + "\" on Yelp.com");

           $("#showPage").css({"display": "inline"});

           console.log(data);
       });
});

$("#businessButton").click(function() {
   $.get("/business", {
       name: $("#businessTerm").val(),
       location: $("#businessLocation").val()
   })
       .done(function(data) {
           searchResults = "";
          $.each(data, function(index, element) {
            searchResults +=("<h1>" + element.name + "</h1><form method='post' action='/business/new/" + element.id +
            "'><input name='_csrf' type='hidden' value='" + $("#csrf-token").attr("content") + "'>" +
            "<button type='submit'>Add to The Database</button></form>")
          });
           $("#businessResults").html(searchResults);
       });
});

$("#logoutButton").click(function () {
    $("#logoutForm").submit()
});
