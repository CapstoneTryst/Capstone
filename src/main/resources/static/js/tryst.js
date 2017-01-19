$(".categories").click(function() {
   $.get("/show", {
       location: "78209"
   })
       .done(function(data) {
           $("#business-name").innerHTML = data.name;
           document.getElementById("business-name").innerHTML = data.name;
           console.log(data.name);
           console.log(data);
       });
});