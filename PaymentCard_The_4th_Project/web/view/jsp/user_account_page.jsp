<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/jTextTags" prefix="jtext"%>
<html>
<head>
    <title><jtext:out value="title.account" after=": "/><c:out default="" value="${currentAccount.getId()}"/></title>
    <link rel="stylesheet" type="text/css" href="/view/css/common.css">
    <link rel="stylesheet" type="text/css" href="/view/css/user_account.css">
</head>
<body>
<jsp:include page="/view/jsp/header.jsp"/>
<hr>
<h3 align="center">
    <jtext:out value="title.account" after=": "/><c:out default="" value="${currentAccount.getId()}"/>
</h3>
<hr><br>
<table class="account_details" align="center">
    <tr class="account_details_caption">
        <td align="center"><jtext:out value="data.id"/></td>
        <td align="center"><jtext:out value="data.account.balance"/></td>
        <td align="center"><jtext:out value="data.account.replenishment.date"/></td>
    </tr>
    <tr>
        <td align="center"><c:out value="${currentAccount.getId()}"/></td>
        <td align="center"><c:out value="${currentAccount.getBalance()/100}"/></td>
        <td align="center"><c:out value="${currentAccount.getRepDate().getTime()}"/></td>
    </tr>
</table>
<br>
<table align="center">
    <c:choose>
        <c:when test="${currentAccount.isBlocked() == true}">
            <c:choose>
                <c:when test="${currentAccount.isToUnblock() == true}">
                    <tr>
                        <td colspan="2">
                            <span style="color: green; font-size: 22px"><jtext:out value="data.in.process"/></span>
                        </td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="2">
                            <form action="/servlet/unblock_request" method="post">
                                <input type="hidden" name="currentAccountId" value="${currentAccount.getId()}">
                                <input type="submit" value="<jtext:out value="button.unblock"/>">
                            </form>
                        </td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </c:when>
        <c:otherwise>
            <tr>
                <td>
                    <form action="/servlet/transition" method="post">
                        <input type="hidden" name="path" value="${pathManager.getUserPaymentUri()}">
                        <input type="hidden" name="currentAccountId" value="${currentAccount.getId()}">
                        <input type="submit" value="<jtext:out value="button.do.payment"/>">
                    </form>
                </td>
            </tr>
            <tr>
                <td>
                    <form action="/servlet/transition" method="post">
                        <input type="hidden" name="path" value="${pathManager.getUserReplenishUri()}">
                        <input type="hidden" name="currentAccountId" value="${currentAccount.getId()}">
                        <input type="submit" value="<jtext:out value="button.do.replenish"/>">
                    </form>
                </td>
            </tr>
            <tr>
                <td>
                    <form action="/servlet/block" method="post">
                        <input type="hidden" name="currentAccountId" value="${currentAccount.getId()}">
                        <input type="submit" value="<jtext:out value="button.block"/>">
                    </form>
                </td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>
