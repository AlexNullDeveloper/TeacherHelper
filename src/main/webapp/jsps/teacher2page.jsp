<%--
  Created by IntelliJ IDEA.
  User: Юрий
  Date: 30.10.2016
  Time: 6:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../html/header.html" %>
<div class="page-header" style="text-align: center;">
    <small>Developers In Pyjamas</small>
    <h1>Teacher Page</h1>
</div>
<div class="container" style="margin-top: 5%;">
    <div class="row">
        <div class="col-md-6">
            <h2 style="margin-bottom: 20px;">Выбранный факультет</h2>
            <div class="list-group">
                <button type="button" class="list-group-item">Cras justo odio</button>
            </div>
        </div>
        <div class="col-md-6">
            <h2 style="margin-bottom: 20px;">Список групп</h2>
            <div class="list-group">
                <button type="button" data-name="Cras justo odio" class="list-group-item button-list-page2">Cras justo odio</button>
                <button type="button" data-name="Cras justo odio" class="list-group-item button-list-page2">Dapibus ac facilisis in</button>
                <button type="button" data-name="Cras justo odio" class="list-group-item button-list-page2">Morbi leo risus</button>
                <button type="button" data-name="Cras justo odio" class="list-group-item button-list-page2">Porta ac consectetur ac</button>
                <button type="button" data-name="Cras justo odio" class="list-group-item button-list-page2">Vestibulum at eros</button>
            </div>
        </div>
    </div>
</div>
<%@include file="../html/footer.html" %>
