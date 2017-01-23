$.get("/user/unrated")
    .done(function(data) {
        $.each(data, function(index, element) {
            console.log(element);
            console.log(element.name);
           $("body").append("<h1>" + element.name + "</h1>");
        });
        console.log(data);
    })
    .fail(function(error) {
       console.log(error);
    });
