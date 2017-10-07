<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title><c:out value="${user.getFirstName()} ${user.getSurname()}"/>: Cards</title>
</head>
<body>
<jsp:include page="exit.jsp"/>
<a href="${pathManager.getUserCabinetUri()}">go to cabinet</a><br>
<table border="1">
    <tr>
        <b>
            <td>ID</td>
            <td>expiration date</td>
            <td>account</td>
        </b>
    </tr>
    <c:forEach items="${user.getCards()}" var="card">
        <tr>
            <td><c:out value="${card.getId()}"/></td>
            <td><c:out value="${card.getExpirationDate().getTime()}"/></td>
            <td><c:out value="${card.getAccountId()}"/></td>
            <td>
                <form action="/servlet/transition">
                    <input type="hidden" name="path" value="${pathManager.getUserAccountPageUri()}">
                    <input type="hidden" name="currentAccountId" value="${card.getAccountId()}">
                    <input type="submit" value="show account">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>