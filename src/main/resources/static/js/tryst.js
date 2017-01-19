$(".categories").click(function() {
   $.get("/show", {
       location: "78209"
   })
       .done(function(data) {
           document.getElementById("businessTitle").innerHTML = data.name;
           document.getElementById("reviewCount").innerHTML = data.review_count + " yelp reviews";
           document.getElementById("businessID").innerHTML = data.phone;
           document.getElementById("ratingImageUrl").innerHTML = data.rating_img_url;
           document.getElementById("businessAddress").innerHTML = data.location.address[0];
           document.getElementById("businessImage").innerHTML = data.image_url;

           console.log(data);
       });
});