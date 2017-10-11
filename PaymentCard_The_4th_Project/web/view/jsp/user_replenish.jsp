<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/jTextTags" prefix="jtext"%>
<html>
<head>
    <title><jtext:out value="title.replenish" after=" : "/><c:out default="" value="${currentAccount.getId()}"/></title>
    <link rel="stylesheet" type="text/css" href="/view/css/common.css">
    <link rel="stylesheet" type="text/css" href="/view/css/contain_table.css">
</head>
<body>
<jsp:include page="/view/jsp/header.jsp"/>
<hr>
<h3 align="center"><jtext:out value="title.replenish"/></h3>
<hr>
<form action="/servlet/replenishment">
    <table class="contain_tab">
        <tr>
            <td><input type="text" name="replenishment" required pattern="[0-9]+(\.[0-9]*)?" class="input_text"
                       placeholder="<jtext:out value="data.amount"/>"></td>
        </tr>
        <tr>
            <td><input type="submit" value="<jtext:out value="button.do.replenish"/>"></td>
        </tr>
        <tr>
            <td><span style="color: red"><jtext:err value="${error}"/></span></td>
        </tr>
    </table>
</form>
</body>
</html>
