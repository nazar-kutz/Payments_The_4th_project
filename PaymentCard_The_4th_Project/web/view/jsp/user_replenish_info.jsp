<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/jTextTags" prefix="jtext"%>
<html>
<head>
    <title><jtext:out value="title.replenish.information"/></title>
    <link rel="stylesheet" type="text/css" href="/view/css/common.css">
</head>
<body>
<jsp:include page="/view/jsp/header.jsp"/>
    <h3><jtext:out value="title.replenish.information" after=":"/></h3>
    <table>
        <tr>
            <td><jtext:out value="data.account" after=": "/></td>
            <td><c:out default="" value="${report.getAccountId()}"/></td>
        </tr>
        <tr>
            <td><jtext:out value="data.sum.of.replenishment" after=": "/></td>
            <td><c:out default="" value="${report.getAmount()/100}"/></td>
        </tr>
        <tr>
            <td><jtext:out value="data.date" after=": "/></td>
            <td><c:out default="" value="${report.getDate().getTime()}"/></td>
        </tr>
        <tr>
            <td><jtext:out value="data.now.your.balance.is" after=": "/></td>
            <td><c:out default="" value="${currentAccount.getBalance()/100}"/></td>
        </tr>
    </table>
</body>
</html>
