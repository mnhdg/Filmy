$(document).ready(function () {
    $('.a').click(function () {
        $.ajax({
            contentType: 'application/json;charset=utf-8',
            url: "http://localhost:8080/filmy",
            type: 'POST',
            data: JSON.stringify({
                "id": document.getElementById("id").value,
                "tytul": document.getElementById("ty").value,
                "kraj": document.getElementById("kr").value,
                "gatunek": document.getElementById("gt").value,
                "cena": document.getElementById("cn").value
            }),
            success: function () {
                alert("Nowy film został dodany do bazy danych")
            },
            error: function () {
                alert("Error");
            }


        }).then(function (data) {
        });
    });

    //delete function
    $('.del').click(function () {
        $.ajax({
            url: "http://localhost:8080/filmy/" + document.getElementById("delete").value,
            type: 'DELETE',
            success: function () {
                alert("Film został usunięty")
            },
            error: function(){
                alert("Error");
            }
        }).then(function (data) {
        });
    });

})