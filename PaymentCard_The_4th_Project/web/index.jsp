<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 23.09.2017
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/jTextTags" prefix="jtext"%>
<html>
<head>
    <title>Index JSP</title>
</head>
<body>
    <h1>Hello from index JSP</h1>
    <jtext:out value="data.you.are.welcome" before="Guest" after=" You can change this"/>
    <form action="/servlet test" method="get">
        <input type="submit" value="<jtext:out value="button.send"/>">
    </form>
</body>
</html>
