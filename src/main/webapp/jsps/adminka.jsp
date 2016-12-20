<%@ page import="com.dip.core.service.TeachersService" %>
<%@ page import="com.dip.core.pojos.Teacher" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Юрий
  Date: 29.10.2016
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<!--
    Страница администратора, позволяющая авторизовать пользователей
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@include file="../resources/html/header.html"%>

<div class="page-header" style="text-align: center;">
    <small>Developers In Pyjamas</small>
    <h1>Admin Page</h1>
</div>



<div class="container" style="margin-top: 5%;">
    <div class="row">
        <div class="col-xs-6">
            <h2 style="margin-bottom: 20px;">Авторизованные</h2>
            <div class="list-group">
                <% for (Teacher teacher : (List<Teacher>) new TeachersService().getListOfAgreedTeachers()) { %>
                    <button type="button" class="list-group-item"><%=teacher.getFamilyName() + " " + teacher.getFirstName()
                            + " " + teacher.getSecondName() + " " + teacher.getPhone()%></button>
                <% }%>
            </div>
        </div>
        <div class="col-xs-6">
            <h2 style="margin-bottom: 20px;">Не авторизованные</h2>
            <div class="list-group">
                <form action="/teacherAgree" method="post" id="example_group2">
                    <% for (Teacher teacher : (List<Teacher>) new TeachersService().getListOfNotAgreedTeachers()) {%>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="teacher_params" value="<%=teacher.getFamilyName() + " " + teacher.getFirstName()
                        + " " + teacher.getSecondName() + " " + teacher.getPhone()%>">
                            <%=teacher.getFamilyName() + " " + teacher.getFirstName()
                                    + " " + teacher.getSecondName() + " " + teacher.getPhone()%>
                        </label>

                        <%--<input type="checkbox" name="checkboxes" value="1"> --%>

                        <%--<button class="list-group-item">--%>
                        <%--<input type="checkbox"> Check me out--%>
                        <%--</button>--%>
                        <%--<button class="list-group-item">--%>
                        <%--<input type="checkbox"> Check me out--%>
                        <%--</button>--%>
                        <%--<button class="list-group-item">--%>
                        <%--<input type="checkbox"> Check me out--%>
                        <%--</button>--%>
                    </div>
                    <% }%>

                        <button type="submit" class="btn btn-primary">Авторизовать</button>

                </form>
                <%--<form action="/teacherDecline" method="post" id="example_group2">--%>
                    <%--<% for (Teacher teacher : (List<Teacher>) new TeachersService().getListOfNotAgreedTeachers()) {%>--%>
                    <%--<div class="checkbox">--%>
                        <%--<label>--%>
                            <%--<input type="checkbox" name="teacher_params" value="<%=teacher.getFamilyName() + " " + teacher.getFirstName()--%>
                        <%--+ " " + teacher.getSecondName() + " " + teacher.getPhone()%>">--%>
                            <%--<%=teacher.getFamilyName() + " " + teacher.getFirstName()--%>
                                    <%--+ " " + teacher.getSecondName() + " " + teacher.getPhone()%>--%>
                        <%--</label>--%>

                        <%--&lt;%&ndash;<input type="checkbox" name="checkboxes" value="1"> &ndash;%&gt;--%>

                        <%--&lt;%&ndash;<button class="list-group-item">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<input type="checkbox"> Check me out&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</button>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<button class="list-group-item">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<input type="checkbox"> Check me out&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</button>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<button class="list-group-item">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<input type="checkbox"> Check me out&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</button>&ndash;%&gt;--%>
                    <%--</div>--%>
                    <%--<% }%>--%>
                    <%--<button type="submit" class="btn btn-danger">Отклонить</button>--%>
                <%--</form>--%>
        </div>
    </div>
</div>
</div>
<script type="text/javascript">
    $(document).ready( function() {
        // Выбор всех
        //При клике по кнопке "отметить все" активируем чекбоксы
        $("#example_all").click( function() {
            $("#" + $(this).attr('rel') + " input:checkbox:enabled").attr('checked', true);
            return false;
        });

        // При клике по кнопке "сбросить все" убираем отметки
        $("#example_noone").click( function() {
            $("#" + $(this).attr('rel') + " input:checkbox:enabled").attr('checked', false);
            return false;
        });
    });
</script>
<footer class="footer">
</footer>
</body>
</html>
