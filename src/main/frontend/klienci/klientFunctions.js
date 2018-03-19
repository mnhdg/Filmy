$(document).ready(function () {
    $('.a').click(function () {
        $.ajax({
            contentType: 'application/json;charset=utf-8',
            url: "http://localhost:8080/klienci",
            type: 'POST',
            data: JSON.stringify({
                "pesel": document.getElementById("ps").value,
                "imie": document.getElementById("im").value,
                "nazwisko": document.getElementById("na").value
            }),
            success: function () {
                alert("Nowy klient został dodany do bazy danych")
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
            url: "http://localhost:8080/klienci/" + document.getElementById("delete").value,
            type: 'DELETE',
            success: function () {
                alert("Klient został usunięty")
            },
            error: function(){
                alert("Error");
            }
        }).then(function (data) {
        });
    });

})