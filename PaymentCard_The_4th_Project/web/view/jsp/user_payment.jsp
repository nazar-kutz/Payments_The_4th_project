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
    <title>Payment <c:out default="" value="by account: ${currentAccount.getId()}"/></title>
</head>
<body>
<jsp:include page="exit.jsp"/>
<form action="/servlet/payment">
    <table>
        <tr>
            <td><input type="text" name="recipient" required pattern="[0-9]+" placeholder="recipient"></td>
        </tr>
        <tr>
            <td><input type="text" name="sum" required pattern="[0-9]+(.[0-9]*)?" placeholder="amount"></td>
        </tr>
        <tr>
            <td><input type="submit" value="send"></td>
        </tr>
        <tr>
            <td><span style="color: red"><c:out default="" value="${error}"></c:out></span></td>
        </tr>
    </table>
</form>
</body>
</html>
