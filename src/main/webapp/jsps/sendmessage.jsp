<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
Страничка подтверждающая отправку сообщений
-->
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8"/>
    <title>Error Page</title>
    <link rel="icon" href="../favicon.png">
    <link rel="stylesheet" href="../resources/css/style.css" type="text/css" />
    <link rel="stylesheet" href="../resources/css/style-form.css" type="text/css" />
    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap-theme.min.css">
    <script src="../resources/js/jquery-3.1.1.min.js"></script>
    <style>
        .footer {
            position: absolute;
            text-align: center;
            left: 0;
            bottom: 0;
            width: 100%;
            height: 80px;
        }
    </style>
</head>
<body>
<div class="page-header" style="text-align: center;">
    <small>Developers In Pyjamas</small>
    <h1>Сообщения успешно отправлены!</h1>

    <div class="container" style="margin-top: 5%;">
        <div class="row">
            <div class="center-container" style="text-align: center;">
                <p style="font-size: 28px; color: #ff6441">Ваши сообщения успешно отправлены. Спасибо за использование нашего сервиса!</p>
                <a href="http://localhost:8080/jsps/teacher.jsp"><button type="button" class="btn btn-primary">Вернуться на главную</button></a>
            </div>
        </div>
    </div>
    <footer class="footer" style="/*background-color: #222;*/">
    </footer>
</body>
</html>