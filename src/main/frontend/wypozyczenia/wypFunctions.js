$(document).ready(function () {
    $('.a').click(function () {
        $.ajax({
            contentType: 'application/json;charset=utf-8',
            url: "http://localhost:8080/wypozyczenia",
            type: 'POST',
            data: JSON.stringify({
                "id": document.getElementById("id2").value,
                "data": document.getElementById("dt").value,
                "film": document.getElementById("fm").value,
                "klient": document.getElementById("kl").value
            }),
            success: function () {
                alert("Nowe wypożyczenie zostało dodane do bazy danych")
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
            url: "http://localhost:8080/wypozyczenia/" + document.getElementById("delete").value,
            type: 'DELETE',
            success: function () {
                alert("Wypożyczenie zostało usunięte")
            },
            error: function(){
                alert("Error");
            }
        }).then(function (data) {
        });
    });

})