<%--
  Created by IntelliJ IDEA.
  User: Юрий
  Date: 30.10.2016
  Time: 4:50
  To change this template use File | Settings | File Templates.
--%>
<!--
    Страничка появляющаяся при неверном логине или пароле, позволяющая вернуться на главную страницу
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8"/>
    <title>Error Page</title>
    <link rel="icon" href="../favicon.png">
    <link rel="stylesheet" href="../css/style.css" type="text/css" />
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.min.css">
    <script src="../resources/js/jquery-3.1.1.min.js"></script>
    <%--<script src="../resources/js/script.js"></script>--%>
</head>
<body>
<div class="page-header" style="text-align: center;">
    <small>Developers In Pyjamas</small>
    <h1>Ошибка!</h1>
</div>


<div class="container" style="margin-top: 5%;">
    <div class="row">
        <div class="center-container" style="text-align: center;">
            <h1 style="color: #ff6441;">Вы ввели неверный логин или пароль, пожалуйста попробуйте снова или зарегистрируйтесь.</h1>
            <a href="http://localhost:8080/"><button type="button" class="btn btn-primary">Вернуться на главную</button></a>
        </div>
    </div>
</div>
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
<footer class="footer" style="/*background-color: #222;*/">

</footer>
</body>
</html>
