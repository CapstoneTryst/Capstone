$(".date_type").click(function() {
   $.get("/show", {
       location: "78209"
   })
       .done(function(data) {
           $("#businessTitle").html(data.name);
           $("#reviewCount").html(data.review_count + " yelp reviews");
           $("#businessPhone").html(data.display_phone);
           $("#ratingImageUrl").attr("src", data.rating_img_url);
           $("#businessAddress").html(data.location.display_address[0] + ", " + data.location.display_address[2]);
           $("#businessImage").attr("src", data.image_url);

           $("#showPage").css({"display": "inline"});

           console.log(data);
       });
});