<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/servlet/login" method="post">
        <table>
            <tr>
                <td>Phone number: </td>
                <td><input type="text " name="login"></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><a href="/view/jsp/registration.jsp">register me</a></td>
                <td><input type="submit" value="sign in"></td>
            </tr>
            <tr>
                <td colspan="2"><span style="color: red">
                    <c:out default="" value="${error}"></c:out></span>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
