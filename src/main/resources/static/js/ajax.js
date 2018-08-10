/**
 * Created by Jun on 2018/7/27.
 */

//window.onload =
function ajax_req() {
        $.ajax({
            async: true,
            type: "GET",
            dataType: 'json',
            url: "/myboot/v1/api/book",
            timeout: 3000,
            contentType: "application/json; charset=utf-8",
            success: function(data){
                var b = data.books;
                for (var index in b){
                    $("#list").append("<tr>" +
                        "<td>" + b[index].id + "</td>" +
                        "<td>" + b[index].name + "</td>" +
                        "<td>" + b[index].price + "</td>" +
                        "<td>" + b[index].quantity + "</td>" +
                        "<td>" + b[index].description + "</td>" +
                        '<td><a href="/myboot/toEdit/' + b[index].id + '">edit</a></td>' +
                        '<td><a href="/myboot/delete/book/' + b[index].id + '">delete</a></td>' +
                        "</tr>");
                }
            }
        });
    }