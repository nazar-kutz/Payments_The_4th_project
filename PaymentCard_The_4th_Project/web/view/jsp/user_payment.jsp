<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/jTextTags" prefix="jtext"%>
<html>
<head>
    <title><jtext:out value="title.payment" after=" "/><c:out default="" value="${currentAccount.getId()}"/></title>
</head>
<body>
<jsp:include page="exit.jsp"/>
<form action="/servlet/payment">
    <table>
        <tr>
            <td><input type="text" name="recipient" required pattern="[0-9]+"
                       placeholder="<jtext:out value="data.recipient"/>"></td>
        </tr>
        <tr>
            <td><input type="text" name="sum" required pattern="[0-9]+(.[0-9]*)?"
                       placeholder="<jtext:out value="data.amount"/>"></td>
        </tr>
        <tr>
            <td><input type="submit" value="<jtext:out value="button.send"/>"></td>
        </tr>
        <tr>
            <td><span style="color: red"><jtext:err value="${error}"/></span></td>
        </tr>
    </table>
</form>
</body>
</html>
