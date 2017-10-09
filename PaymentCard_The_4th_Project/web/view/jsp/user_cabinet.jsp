<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/jTextTags" prefix="jtext"%>
<html>
<head>
    <title><c:out value="${user.getFirstName()} ${user.getSurname()}"/></title>
</head>
<body>
<jsp:include page="exit.jsp"/>
<jsp:include page="language.jsp"/>
<div class="greeting">
    <h3><c:out value="${user.getFirstName()}"/><jtext:out value="data.you.are.welcome"/></h3><br>
</div>
<div class="user_profile">
    <table>
        <caption><jtext:out value="data.your.personal.information"/></caption>
        <tr>
            <td><jtext:out value="data.first.name" after=": "/></td>
            <td><c:out value="${user.getFirstName()}"/></td>
        </tr>
        <tr>
            <td><jtext:out value="data.last.name" after=": "/></td>
            <td><c:out value="${user.getSurname()}"/></td>
        </tr>
        <tr>
            <td><jtext:out value="data.patronymic" after=": "/></td>
            <td><c:out value="${user.getPatronymic()}"/></td>
        </tr>
        <tr>
            <td><jtext:out value="data.phone.number" after=": "/></td>
            <td><c:out value="${user.getLogin()}"/></td>
        </tr>
        <tr>
            <td><jtext:out value="data.registration.date" after=": "/></td>
            <td><c:out value="${user.getRegistrationDate().getTime()}"/></td>
        </tr>
    </table>
</div>
<div class="user_links">
    <h3>
        <table>
            <tr>
                <td><jtext:out value="data.my.cards" after=": "/></td>
                <td><a href="${pathManager.getUserCardReviewUri()}">
                    <jtext:out value="link.go.to.my.cards"/>
                </a></td>
            </tr>
            <tr>
                <td><jtext:out value="data.my.accounts" after=": "/></td>
                <td><a href="${pathManager.getUserAccountReviewUri()}">
                    <jtext:out value="link.go.to.my.accounts"/>
                </a></td>
            </tr>
        </table>
    </h3>
</div>
</body>
</html>
