<%@ page import="com.dip.core.pojos.Faculty" %>
<%@ page import="com.dip.core.service.FacultiesService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dip.core.service.GroupsService" %>
<%@ page import="com.dip.core.service.StudentService" %><%--
  Created by IntelliJ IDEA.
  User: Юрий
  Date: 29.10.2016
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<!--
Страница отвечающая за возможность преподавателя выбора Факультета, группы и рассылки сообщений
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../resources/html/header.html" %>
<div class="page-header" style="text-align: center;">
    <small>Developers In Pyjamas</small>
    <h1>Teacher Page</h1>
</div>
<div class="container" style="margin-top: 5%;">
    <div class="row">
        <div class="col-md-4">
            <h2 style="margin-bottom: 20px;">Факультет</h2>
            <div class="list-group">

                <% for (Faculty faculty : (List<Faculty>) new FacultiesService().getListOfFaculties()) {%>
                <button type="button" data-name="<%=faculty.getName()%>" class="list-group-item button-list"><%=faculty.getVuz() + " " + faculty.getName()%></button>
                <%}%>
            </div>
        </div>
        <div class="col-md-4">
            <h2 style="margin-bottom: 20px;">Список групп</h2>
            <div class="list-group">
                <% for (String str : new GroupsService().getListOfGroupsByFacName("ИУ") ) { %>
                    <button type="button" class="list-group-item"><%= str%></button>
                <%}%>
            </div>
        </div>
        <div class="col-md-4">
            <h2 style="margin-bottom: 20px;">Список учащихся</h2>
            <div class="list-group">

                <% for (String str : new StudentService().getStudentListByName("ГРУППА 1")) {%>
                <button class="list-group-item">
                   <%= str%>
                </button>
                <% } %>
            </div>
            <form action="/sendMessage" method="post">
                <input type="text" name="messageHeader" class="form-control" placeholder="Заголовок письма">
                <textarea class="form-control" name="messageBody" rows="7" placeholder="Сообщение"></textarea>
                <button type="submit" class="btn btn-primary">Отправить сообщение</button>
            </form>
        </div>
    </div>
</div>
<%@include file="../resources/html/footer.html" %>
