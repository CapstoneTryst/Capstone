var searchResults = "";
var category = "";

$(".date_type").click(function() {
    category = $(this).data("db-id");
    $("#wrapper").fadeIn();
   $.get("/show", {
       location: $("#location").val(),
       category: $(this).data("db-id")
   })
       .done(function(data) {
           $("#businessTitle").html(data.name);
           $("#reviewCount").html(data.review_count + " yelp reviews");
           $("#businessPhone").html(data.display_phone);
           $("#ratingImageUrl").attr("src", data.rating_img_url_large);
           $("#businessAddress").html(data.location.address[0] + ", " + data.location.city + ", " + data.location.state_code + " " + data.location.postal_code);
           $("#businessImage").attr("src", data.image_url.substring(0, data.image_url.length - 6) + "o.jpg");
           $("#yelpUrl").attr("href", data.url).html("See More about \"" + data.name + "\" on Yelp.com");

           $(".select-place-to-go").data("business-id", data.id);
           $("#try-again").data("db-id", category);

           $("#showPage").css({"display": "inline"});
           $('html,body').animate({
                   scrollTop: $('.second').offset().top},
               'slow');

           $("#wrapper").fadeOut();
       })
       .error(function(error) {
           $("#wrapper").fadeOut();
       })
});

$("#businessButton").click(function() {
    $("#wrapper").fadeIn();
   $.get("/business", {
       name: $("#businessTerm").val(),
       location: $("#businessLocation").val()
   })
       .done(function(data) {
           searchResults = "<hr>";
          $.each(data, function(index, element) {
            searchResults += "<div class='col-sm-4'><img src='" + element.image_url.substring(0, element.image_url.length - 6) + "ls.jpg' class='img-rounded' width='200' height='200'>" +
                "<h1>" + element.name + "</h1>" + "" +
                "<p>" + element.location.address[0] + ", " + element.location.city + ", " + element.location.state_code + " " + element.location.postal_code + "</p>" +
                "<form method='post' action='/business/new/" + element.id + "'>" +
                "<input name='_csrf' type='hidden' value='" + $("#csrf-token").attr("content") + "'>" +
                "<button class='btn' type='submit'>Rate this spot</button>" +
                "</form>" +
                "</div>";
          });
           $("#businessResults").html(searchResults);
           $("#wrapper").fadeOut();
       })
       .error(function(error) {
           $("#wrapper").fadeOut();
       })
});

$(".select-place-to-go").click(function() {
   $.ajax({
       method: "POST",
       url: "/business/new",
       beforeSend: function(request) {
           request.setRequestHeader($("#csrf-header").attr("content"), $("#csrf-token").attr("content"))
       },
       data: {
           businessId: $(this).data("business-id")
       }
   })
       .done(function(data) {
           swal({
               title: "It's a Date!",
               text: "Don't Forget To Rate This Spot!",
               type: "success"
           });

       })
       .fail(function(error) {
       });
});




$("#logoutButton").click(function () {
    $("#logoutForm").submit()
});

// $(".date_type").hover(function(){
//     this.
//     })