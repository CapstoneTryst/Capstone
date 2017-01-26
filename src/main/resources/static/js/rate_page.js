(function() {
    var categories = ["Casual First Date", "Anniversary", "Outdoors", "Sight Seeing", "Romantic Date", "Relaxing Date", "First Date IRL", "Artsy", "Live Music", "No $$ No Problem", "Classy"];
    var ratingString = "";
    $.get("/user/unrated")
        .done(function (data) {
            ratingString = "";
            $.each(data, function (index, element) {
                ratingString += "<div><div class='col-sm-12'><h2 class='col-sm-4'>" + element.name + "</h2>" +
                    "<a id='yelpUrl' href='" + element.url + "'class='col-sm-4' target='_blank' style='margin-top: 35px' rel='noopener'>See More about " + element.name + " on Yelp!</a></div>" +
                    "<table class='table'><tr>";
                for (var i = 1; i <= 11; i++) {
                    ratingString +=
                        "<td class='text-center'><form class='stopform' method='post' action='/business/positive'>"
                        + "<input type='hidden' name='_csrf' value='" + $("#csrf-token").attr("content") + "'>"
                        + "<input type='hidden' name='category' value='" + i + "'>"
                        + "<input type='hidden' name='businessId' value='" + element.id + "'>"
                        + "<button class='submit-positive btn' type='submit'>+</button>"
                        + "</form>"
                        + "<p></p>"
                        + "<p>" + categories[i - 1] + "</p>"
                        + "<form class='stopform' method='post' action='/business/negative'>"
                        + "<input type='hidden' name='_csrf' value='" + $("#csrf-token").attr("content") + "'>"
                        + "<input type='hidden' name='category' value='" + i + "'>"
                        + "<input type='hidden' name='businessId' value='" + element.id + "'>"
                        + "<button class='submit-negative btn' type='submit'>-</button>"
                        + "</form></td>"
                }
                ratingString += "</tr></table></div>"

            });
            $("#businesses-to-rate").html(ratingString);

            $(".stopform").submit(function (e) {
                e.preventDefault();
            });

            $(".submit-positive").click(function() {
               $.ajax({
                   method: "POST",
                   url: "/business/positive",
                   data: $(this).closest("form").serialize()
               })
                   .done(function(data) {
                       console.log(data);
                       console.log("This is done")
                   })
                   .error(function(error) {
                       console.log(error);
                       console.log("This failed");
                   })
            });
            $(".submit-negative").click(function() {
                $.ajax({
                    method: "POST",
                    url: "/business/negative",
                    data: $(this).closest("form").serialize()
                })
                    .done(function(data) {
                        console.log(data);
                        console.log("This is done")
                    })
                    .error(function(error) {
                        console.log(error);
                        console.log("This failed");
                    })
            });
            console.log(data);
        })
        .fail(function (error) {
            console.log(error);
        });


})();
