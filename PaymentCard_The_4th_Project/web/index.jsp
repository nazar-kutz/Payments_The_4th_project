<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 23.09.2017
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index JSP</title>
</head>
<body>
    <h1>Hello from index JSP</h1>
    <h1>There is next encoding: </h1><%=request.getCharacterEncoding()%>
    <form action="/servlet test" method="get">
        <input type="submit" value="go">
    </form>
</body>
</html>
