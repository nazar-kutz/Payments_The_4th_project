<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/jTextTags" prefix="jtext" %>
<html>
<head>
    <title><c:out value="${user.getFirstName()} ${user.getSurname()}"/></title>
    <link rel="stylesheet" type="text/css" href="/view/css/common.css">
    <link rel="stylesheet" type="text/css" href="/view/css/user_cabinet.css">
</head>
<body>
<jsp:include page="/view/jsp/header.jsp"/>
<hr>
<h3 align="center"><c:out value="${user.getFirstName()}"/><jtext:out value="data.you.are.welcome"/></h3>
<hr>
<br>
<table class="user_table" align="center">
    <caption><jtext:out value="data.your.personal.information"/></caption>
    <tr>
        <td><jtext:out value="data.first.name" after=": "/></td>
        <td><c:out value="${user.getFirstName()}"/></td>
    </tr>
    <tr>
        <td><jtext:out value="data.last.name" after=": "/></td>
        <td><c:out value="${user.getSurname()}"/></td>
    </tr>
    <tr>
        <td><jtext:out value="data.patronymic" after=": "/></td>
        <td><c:out value="${user.getPatronymic()}"/></td>
    </tr>
    <tr>
        <td><jtext:out value="data.phone.number" after=": "/></td>
        <td><c:out value="${user.getLogin()}"/></td>
    </tr>
    <tr>
        <td><jtext:out value="data.registration.date" after=": "/></td>
        <td><c:out value="${user.getRegistrationDate().getTime()}"/></td>
    </tr>
</table>
</body>
</html>
