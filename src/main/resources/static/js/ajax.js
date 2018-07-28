/**
 * Created by Jun on 2018/7/27.
 */

function myAjax(url) {
        $.ajax({
            async: true,
            type: "GET",
            dataType: 'json',
            url: url,
            timeout: 3000,
            contentType: "application/json; charset=utf-8",
            success: function(data){
                var b = data.books;
                for (var index in b){
                    $("#list").prepend("<tr>" +
                        "<td>" + b[index].id + "</td>" +
                        "<td>" + b[index].name + "</td>" +
                        "<td>" + b[index].price + "</td>" +
                        "<td>" + b[index].quantity + "</td>" +
                        "<td>" + b[index].description + "</td>" +
                        "</tr>");
                }
            }
        });
    }