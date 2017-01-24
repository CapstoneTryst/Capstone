(function() {
    var ratingString = "";
    $.get("/user/unrated")
        .done(function (data) {
            ratingString = "";
            $.each(data, function (index, element) {
                ratingString += "<h1>" + element.name + "</h1>";
                for (var i = 1; i <= 10; i++) {
                    ratingString +=
                        "<div class='d-inline'>"
                        + "<form class='stopform' method='post' action='/business/positive'>"
                        + "<input type='hidden' name='_csrf' value='" + $("#csrf-token").attr("content") + "'>"
                        + "<input type='hidden' name='category' value='" + i + "'>"
                        + "<input type='hidden' name='businessId' value='" + element.id + "'>"
                        + "<button class='submit-positive btn' type='submit'>+</button>"
                        + "</form>"
                        + "<p>category " + i + "</p>"
                        + "<form class='stopform' method='post' action='/business/negative'>"
                        + "<input type='hidden' name='_csrf' value='" + $("#csrf-token").attr("content") + "'>"
                        + "<input type='hidden' name='category' value='" + i + "'>"
                        + "<input type='hidden' name='businessId' value='" + element.id + "'>"
                        + "<button class='submit-negative btn' type='submit'>-</button>"
                        + "</form>"
                        + "</div>"
                }

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
