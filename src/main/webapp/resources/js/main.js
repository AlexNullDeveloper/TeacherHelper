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

    function getParameterByName(name, url) {
        if (!url) {
            url = window.location.href;
        }
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(url);
        if (!results) return null;
        if (!results[2]) return '';
        return decodeURIComponent(results[2].replace(/\+/g, " "));
    }

    var name = "";
    $(this).on('click', ".button-list", function () {
        var name = $(this).data("name");
        alert (name);

        $.ajax({
            url: "/returnGroups?name=" + name
        }).done(function(result) {
            var data = JSON.parse(result);




            console.log(data);
            console.log(data.url);
            console.log(data.Groups);

            var url = data.url;

            var new_url = url + insertParam(url, "previousFaculty", data.previousFaculty);
            for (var i = 0; i < data.Groups.length; i++) {
                new_url = new_url + insertParam(url, i, data.Groups[i]);
            }

            console.log("new_url" + new_url)
            //window.location.href = new_url;
            //window.location.href = result;
            // var all = JSON.parse(result.response.text);
            // console.log (all);
            // var groups = JSON.parse();
            // $( this ).addClass( "done" );
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
            // $( this ).addClass( "done" );
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