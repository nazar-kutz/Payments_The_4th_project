<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/jTextTags" prefix="jtext" %>
<html>
<head>
    <title><c:out value="${user.getFirstName()} ${user.getSurname()}"/></title>
    <link rel="stylesheet" type="text/css" href="/view/css/common.css">
    <link rel="stylesheet" type="text/css" href="/view/css/admin_cabinet.css">
</head>
<body>
<jsp:include page="/view/jsp/header.jsp"/>
<hr>
<h3 align="center"><c:out value="${user.getFirstName()}"/><jtext:out value="data.you.are.welcome"/></h3>
<hr>
<c:choose>
    <c:when test="${unblock == null || unblock.size() == 0}"></c:when>
    <c:otherwise>
        <table class="admin_table" align="center">
            <tr style="font-weight: 900">
                <td><jtext:out value="data.id"/></td>
                <td><jtext:out value="data.account.balance"/></td>
                <td><jtext:out value="data.account.replenishment.date"/></td>
            </tr>
            <form action="/servlet/unblock">
                <c:forEach items="${unblock}" var="account">
                    <tr>
                        <td><c:out value="${account.getId()}"/></td>
                        <td><c:out value="${account.getBalance()/100}"/></td>
                        <td><c:out value="${account.getRepDate().getTime()}"/></td>
                        <td align="left"><input type="checkbox" name="unblockItem" value="${account.getId()}"></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="4"><input type="submit" value="<jtext:out value="button.unblock"/>"></td>
                </tr>
            </form>
        </table>
    </c:otherwise>
</c:choose>
</body>
</html>
