<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/jTextTags" prefix="jtext" %>
<html>
<head>
    <title><c:out value="${user.getFirstName()} ${user.getSurname()}"/>
        <jtext:out value="title.accounts.review" before=" : "/></title>
    <link rel="stylesheet" type="text/css" href="/view/css/common.css">
    <link rel="stylesheet" type="text/css" href="/view/css/reviews.css">
</head>
<body>
<jsp:include page="/view/jsp/header.jsp"/>
<hr>
<h3 align="center"><jtext:out value="link.go.to.my.accounts"/></h3>
<hr>
<br>
<table class="review_table" align="center">
    <tr style="font-weight: 900">
        <td><jtext:out value="data.id"/></td>
        <td><jtext:out value="data.account.balance"/></td>
        <td><jtext:out value="data.account.replenishment.date"/></td>
    </tr>
    <c:forEach items="${user.getAccounts()}" var="account">
        <tr>
            <td><c:out value="${account.getId()}"/></td>
            <td><c:out value="${account.getBalance()/100}"/></td>
            <td><c:out value="${account.getRepDate().getTime()}"/></td>
            <td>
                <form action="/servlet/transition" method="post">
                    <input type="hidden" name="path" value="${pathManager.getUserAccountPageUri()}">
                    <input type="hidden" name="currentAccountId" value="${account.getId()}">
                    <input type="submit" value="<jtext:out value="button.show.account"/>">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
