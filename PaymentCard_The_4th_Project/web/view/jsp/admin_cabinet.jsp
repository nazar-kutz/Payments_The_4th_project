<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 18:47
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
<table border="1">
    <tr>
        <b>
            <td>ID</td>
            <td>balance</td>
            <td>replenish date</td>
        </b>
    </tr>
    <form action="/servlet/unblock">
<c:forEach items="${unblock}" var="account">
        <tr>
            <td><c:out value="${account.getId()}"/></td>
            <td><c:out value="${account.getBalance()/100}"/></td>
            <td><c:out value="${account.getRepDate().getTime()}"/></td>
            <td><input type="checkbox" name="unblockItem" value="${account.getId()}"></td>
        </tr>
</c:forEach>
        <tr>
            <td><input type="submit" value="unblock"></td>
        </tr>
    </form>
</table>
</body>
</html>