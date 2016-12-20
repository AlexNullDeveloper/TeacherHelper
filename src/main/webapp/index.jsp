<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 29.10.2016
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<!--
Главная страница вэб-приложения с авторизацией
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@include file="resources/html/header.html" %>--%>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8"/>
    <title>Teacher</title>
    <link rel="icon" href="/favicon.png">
    <link rel="stylesheet" href="/resources/css/style.css" type="text/css" />
    <link rel="stylesheet" href="/resources/css/style-form.css" type="text/css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-theme.min.css">

    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/js/main.js"></script>
</head>
<body>
<div class="page-header" style="text-align: center;">
    <div class="logo-form"><img src="img/logo.png"></div>
</div>
<div class="container">
    <section>
        <div id="container" >
            <!-- hidden anchoruhkh to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form  action="/auth" method="post" autocomplete="on">
                        <p class="text-form">Авторизоваться на сайте</p>
                        <p>
                            <input id="username" name="username" required="required" type="text" placeholder="Ваш email или логин"/>
                        </p>
                        <p>
                            <input id="password" name="password" required="required" type="password" placeholder="Ваш пароль" />
                        </p>
                        <p class="keeplogin">
                            <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" />
                            <label for="loginkeeping">Запомнить меня</label>
                        </p>
                        <p class="login button">
                            <input type="submit" value="Войти" />
                        </p>
                        <p class="change_link">
                            Вы еще не с нами?
                            <a href="#toregister" class="to_register">Присоединиться</a>
                        </p>
                    </form>
                </div>
                <div id="register" class="animate form">
                    <form  action="/auth" method="post" autocomplete="on">
                        <p class="text-form">Зарегистрироваться на сайте</p>
                        <p>
                            <input class="fa fa-address-book" id="surnamesignup" name="surnamesignup" required="required" type="text" placeholder="Фамилия"/>
                        </p>
                        <p>
                            <input id="namesignup" name="namesignup" required="required" type="text" placeholder="Имя"/>
                        </p>
                        <p>
                            <input id="fathersnamesignup" name="fathersnamesignup" required="required" type="text" placeholder="Отчество"/>
                        </p>
                        <p>
                            <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="Ваш логин" />
                        </p>
                        <p>
                            <input id="emailsignup" name="emailsignup" required="required" type="text" placeholder="Ваш email"/>
                        </p>
                        <p>
                            <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="Ваш пароль"/>
                        </p>
                        <p>
                            <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="Пожалуйста, подтвердите пароль"/>
                        </p>
                        <p class="signin button">
                            <input type="submit" value="Регистрация"/>
                        </p>
                        <p class="change_link">
                            Вы уже зарегистрированы?
                            <a href="#tologin" class="to_register"> Тогда войдите </a>
                        </p>
                    </form>
                </div>

            </div>
        </div>

    </section>
</div>
<%@include file="resources/html/footer.html" %>