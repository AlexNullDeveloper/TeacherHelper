$(document).ready(function () {

    function insertParam(url, param, value) {
        var a = document.createElement('a'), regex = /(?:\?|&amp;|&)+([^=]+)(?:=([^&]*))*/g;
        var match, str = []; a.href = url; param = encodeURIComponent(param);
        while (match = regex.exec(a.search))
            if (param != match[1]) str.push(match[1]+(match[2]?"="+match[2]:""));
        str.push(param+(value?"="+ encodeURIComponent(value):""));
        a.search = str.join("&");
        return a.href;
    }

    var name = "";
    $(this).on('click', ".group-list", function () {
        var name = $(this).data("name");
        var results;
        $.ajax({
            url: "/returnStudents?name=" + name,
            result: results,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");

            },
            success: function(data)
            {
                // alert("success");
                console.log("success")
            },
            error: function (request, status, error) {
                alert("error");
                console.log(error);
            }
        }).done(function(result) {
            console.log("done");
            alert.log
            console.log(result);

            var html = "";
            for (var i = 0; i < result.length; i++) {
                console.log("i = " + i);
                console.log(result[i]);
                html += "<button class=\"list-group-item\">" + result[i] + "</button>";
            }

            document.getElementsByClassName("list-students")[0].innerHTML = html;

        }).fail(function(e) {
            console.log(e);
        });

    });


    $(this).on('click', ".faculty-list", function () {
        var name = $(this).data("name");
        var results;

        $.ajax({
            url: "/returnGroups?name=" + name,
            result: results,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");

            },
            success: function(data)
            {
                // alert("success");
                console.log("success")
            },
            error: function (request, status, error) {
                alert("error");
                console.log(error);
            }
        }).done(function(result) {
            console.log(result);

            var html = "";
            for (var i = 0; i < result.length; i++) {
                console.log("i = " + i);
                console.log(result[i]);
                html += "<button type=\"button\" data-name=\"" + result[i] + "\"class=\"list-group-item group-list\">" + result[i] + "</button>";
            }

            document.getElementsByClassName("list-group")[0].innerHTML = html;
        }).fail(function(e) {
            console.log(e);
        });

    });

    $(this).on('click', ".button-list-page2", function () {
        var name_group = $(this).data("name");
        alert (name);
        alert (name_group);

        $.ajax({
            url: "/submit?name_group=" + name_group
        }).done(function(result) {
            console.log(result);
        }).fail(function(e) {
            console.log(e);
        });
    });
});
$(function () {
    $('.popup-modal').magnificPopup({
        type: 'inline',
        preloader: false,
        focus: '#username',
        modal: true
    });
    $(document).on('click', '.popup-modal-dismiss', function (e) {
        e.preventDefault();
        $.magnificPopup.close();
    });
});