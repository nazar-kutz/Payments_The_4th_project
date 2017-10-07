<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title><c:out value="${user.getFirstName()} ${user.getSurname()}"/>: Accounts</title>
</head>
<body>
<jsp:include page="exit.jsp"/>
<a href="${pathManager.getUserCabinetUri()}">go to cabinet</a><br>
<table border="1">
    <tr>
        <b>
            <td>ID</td>
            <td>balance</td>
            <td>replenish date</td>
        </b>
    </tr>
    <c:forEach items="${user.getAccounts()}" var="account">
        <tr>
            <td><c:out value="${account.getId()}"/></td>
            <td><c:out value="${account.getBalance()/100}"/></td>
            <td><c:out value="${account.getRepDate().getTime()}"/></td>
            <c:choose>
                <c:when test="${account.isBlocked() == true}">
                    <c:choose>
                            <c:when test="${account.isToUnblock() == true}">
                                <td colspan="4">
                                    <span style="color: green">in process</span>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td colspan="4">
                                    <form action="/servlet/unblock_request">
                                        <input type="hidden" name="currentAccountId" value="${account.getId()}">
                                        <input type="submit" value="unblock">
                                    </form>
                                </td>
                            </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <td>
                        <form action="/servlet/transition">
                            <input type="hidden" name="path" value="${pathManager.getUserAccountPageUri()}">
                            <input type="hidden" name="currentAccountId" value="${account.getId()}">
                            <input type="submit" value="show account">
                        </form>
                    </td>
                    <td>
                        <form action="/servlet/transition">
                            <input type="hidden" name="path" value="${pathManager.getUserPaymentUri()}">
                            <input type="hidden" name="currentAccountId" value="${account.getId()}">
                            <input type="submit" value="do payment">
                        </form>
                    </td>
                    <td>
                        <form action="/servlet/transition">
                            <input type="hidden" name="path" value="${pathManager.getUserReplenishUri()}">
                            <input type="hidden" name="currentAccountId" value="${account.getId()}">
                            <input type="submit" value="replenish">
                        </form>
                    </td>
                    <td>
                        <form action="/servlet/block">
                            <input type="hidden" name="currentAccountId" value="${account.getId()}">
                            <input type="submit" value="block">
                        </form>
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
</table>
</body>
</html>
