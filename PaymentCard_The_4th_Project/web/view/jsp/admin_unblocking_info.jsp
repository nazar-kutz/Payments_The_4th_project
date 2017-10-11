<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/jTextTags" prefix="jtext"%>
<html>
<head>
    <title><jtext:out value="title.unblocking.information"/></title>
    <link rel="stylesheet" type="text/css" href="/view/css/common.css">
</head>
<body>
<jsp:include page="/view/jsp/header.jsp"/>
<ul>
    <c:forEach items="${reports}" var="report">
        <li><c:out value="${report.getInfo()}"/></li>
    </c:forEach>
</ul>
</body>
</html>
