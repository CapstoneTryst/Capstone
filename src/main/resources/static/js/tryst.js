$(".date_type").click(function() {
   $.get("/show", {
       location: $("#location").val()
   })
       .done(function(data) {
           $("#businessTitle").html(data.name);
           $("#reviewCount").html(data.review_count + " yelp reviews");
           $("#businessPhone").html(data.display_phone);
           $("#ratingImageUrl").attr("src", data.rating_img_url);
           $("#businessAddress").html(data.location.address[0] + "| " + data.location.city + ", " + data.location.state_code + " " + data.location.postal_code);
           $("#businessImage").attr("src", data.image_url);

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
          $.each(data, function(index, element) {
            $("#businessResults").append("<h1>" + element.name + "</h1>")
          });
       });
});