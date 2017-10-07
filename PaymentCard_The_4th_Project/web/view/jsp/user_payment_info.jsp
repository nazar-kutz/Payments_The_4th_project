<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Payment information</title>
</head>
<body>
<h3>payment information:</h3>
<table>
    <tr>
        <td>sender account: </td>
        <td><c:out default="" value="${report.getAccountId()}"/></td>
    </tr>
    <tr>
        <td>recipient account: </td>
        <td><c:out default="" value="${report.getRecipient()}"/></td>
    </tr>
    <tr>
        <td>sum of the replenishment: </td>
        <td><c:out default="" value="${report.getAmount()/100}"/></td>
    </tr>
    <tr>
        <td>date: </td>
        <td><c:out default="" value="${report.getDate().getTime()}"/></td>
    </tr>
    <tr>
        <td>now your balance is: </td>
        <td><c:out default="" value="${currentAccount.getBalance()/100}"/></td>
    </tr>
</table>
</body>
</html>
