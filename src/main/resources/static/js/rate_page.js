(function() {
    var categories = ["Casual First Date", "Anniversary", "Outdoors", "Sight Seeing", "Romantic Date", "Relaxing Date", "First Date IRL", "Artsy", "Live Music", "No $$ No Problem", "Classy"];
    var ratingString = "";
    var modelAreaString = "";
    $.get("/user/unrated")
        .done(function (data) {
            ratingString = "";
            modelAreaString = "";
            $.each(data, function (index, element) {
                ratingString += "<div class='col-sm-12 text-center liked-business'><img src='" + element.image_url.substring(0, element.image_url.length - 6) + "ls.jpg' class='img-rounded' width='200' height='200'/><h2>" + element.name + "</h2>" +
                    "<button type='button' class='btn transparent-button' data-toggle='modal' data-target='#" + element.id +"-model'>Rate it</button></div>";

                modelAreaString += "<div class='modal fade' id='" + element.id + "-model' tabindex='-1' role='dialog' aria-labelledby='myLargeModalLabel'>" +
                    "<div class='modal-dialog modal-lg' role='document'>" +
                    "<div class='modal-content modal-color'>" +
                    "<div class='modal-header'>" +
                    "<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'></span></button>" +
                    "<h4 class='modal-title' id='myLargeModalLabel'>Rate " + element.name + "</h4>" +
                    "</div>" +
                    "<div class='modal-body'>" +
                    "<table class='table'><tr>";

                for (var i = 1; i <= 11; i++) {
                    modelAreaString +=
                        "<td class='text-center'><form class='stopform' method='post' action='/business/positive'>"
                        + "<input type='hidden' name='_csrf' value='" + $("#csrf-token").attr("content") + "'>"
                        + "<input type='hidden' name='category' value='" + i + "'>"
                        + "<input type='hidden' name='businessId' value='" + element.id + "'>"
                        + "<button class='submit-positive btn' type='submit'>+</button>"
                        + "</form>"
                        + "<p>" + categories[i - 1] + "</p>"
                        + "<form class='stopform' method='post' action='/business/negative'>"
                        + "<input type='hidden' name='_csrf' value='" + $("#csrf-token").attr("content") + "'>"
                        + "<input type='hidden' name='category' value='" + i + "'>"
                        + "<input type='hidden' name='businessId' value='" + element.id + "'>"
                        + "<button class='submit-negative btn' type='submit'>-</button>"
                        + "</form></td>"
                }
                modelAreaString += "</tr></table>" +
                    "</div>" +
                    "<div class='modal-footer'>" +
                    "<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>" +
                    "</div>" +
                    "</div></div></div>"

            });
            $("#businesses-to-rate").html(ratingString);
            $("#modelArea").html(modelAreaString);

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
                       swal({
                           title: "Success",
                           text: "You've rated this!",
                           type: "success"
                       });
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
                        swal({
                            title: "Success",
                            text: "You've rated this!",
                            type: "success"
                        });
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
