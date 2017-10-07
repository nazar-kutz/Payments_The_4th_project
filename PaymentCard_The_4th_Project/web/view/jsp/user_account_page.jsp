<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Account: <c:out default="not account" value="${currentAccount.getId()}"/></title>
</head>
<body>
<jsp:include page="exit.jsp"/>
</body>
</html>
