<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title><c:out value="${user.getFirstName()} ${user.getSurname()}"/></title>
</head>
<body>
<jsp:include page="exit.jsp"/>
<div class="greeting">
    <h3><c:out value="${user.getFirstName()}"/>, you are welcome!</h3><br>
</div>
<div class="user_profile">
    <table>
        <caption>Your personal information</caption>
        <tr>
            <td>first name:</td>
            <td><c:out value="${user.getFirstName()}"/></td>
        </tr>
        <tr>
            <td>last name:</td>
            <td><c:out value="${user.getSurname()}"/></td>
        </tr>
        <tr>
            <td>patronymic:</td>
            <td><c:out value="${user.getPatronymic()}"/></td>
        </tr>
        <tr>
            <td>phone:</td>
            <td><c:out value="${user.getLogin()}"/></td>
        </tr>
        <tr>
            <td>registration date:</td>
            <td><c:out value="${user.getRegistrationDate().getTime()}"/></td>
        </tr>
    </table>
</div>
<div class="user_links">
    <h3>
        <table>
            <tr>
                <td>my cards: </td>
                <td><a href="${pathManager.getUserCardReviewUri()}">go to my cards</a></td>
            </tr>
            <tr>
                <td>my accounts: </td>
                <td><a href="${pathManager.getUserAccountReviewUri()}">go to my accounts</a></td>
            </tr>
        </table>
    </h3>
</div>
</body>
</html>
