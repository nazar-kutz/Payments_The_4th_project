<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 10.10.2017
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/jTextTags" prefix="jtext"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/view/css/header.css">
</head>
<body>
<table class="header_tab">
    <tr>
        <td align="center">
            <c:choose>
                <c:when test="${user.getRole().toString() == \"ADMIN\"}">
                    <a href="${pathManager.getAdminCabinetUri()}" class="menu_point">
                        <jtext:out value="link.go.to.cabinet"/></a>
                </c:when>
                <c:otherwise>
                    <a href="${pathManager.getUserCabinetUri()}" class="menu_point">
                        <jtext:out value="link.go.to.cabinet"/></a>
                </c:otherwise>
            </c:choose>
        </td>
        <td align="center">
            <a href="${pathManager.getUserCardReviewUri()}" class="menu_point">
                <jtext:out value="link.go.to.my.cards"/></a>
        </td>
        <td align="center">
            <a href="${pathManager.getUserAccountReviewUri()}" class="menu_point">
                <jtext:out value="link.go.to.my.accounts"/>
            </a>
        </td>
        <td align="center">
            <a href="/view/jsp/language.jsp" class="menu_point"><jtext:out value="link.language"/></a>
        </td>
        <td align="center">
            <a href="/servlet/exit" class="menu_point"><jtext:out value="button.exit"/></a>
        </td>
    </tr>
</table>
</body>
</html>
