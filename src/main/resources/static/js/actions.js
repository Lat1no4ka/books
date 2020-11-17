


$( document ).ready(function() {
    $.ajax({
        type: "GET",
        url: "/api/getBooks",
        contentType: 'application/json',
        success: function(data) {
             console.log(data);
        }
    });
    $.ajax({
        type: "GET",
        url: "/api/getGroupBooks",
        contentType: 'application/json',
        success: function(data) {
            console.log(data);
        }
    });
    $( "#insert" ).on( "click", function() {
        let id= $("#id").val();
        let title = $("#title").val();
        let author = $("#author").val();
        let desc = $("#desc").val();
        $.ajax({
            type: "POST",
            url: "/api/addBook",
            data: JSON.stringify({id:id, title: title, author: author, description:desc}),
            contentType: 'application/json',
            success: function(data) {
                console.log(data);
            }
        });

    })
});