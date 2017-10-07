<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <form action="/servlet/registration">
        <table>
            <tr>
                <td>First name: </td>
                <td><input type="text" name="fname" required pattern="[a-zA-Z]+"></td>
            </tr>
            <tr>
                <td>Last name: </td>
                <td><input type="text" name="lname" required pattern="[a-zA-Z]+"></td>
            </tr>
            <tr>
                <td>Patronymic: </td>
                <td><input type="text" name="patronymic" required pattern="[a-zA-Z]+"></td>
            </tr>
            <tr>
                <td>Phone number: </td>
                <td><input type="text" name="phone" required pattern=
                        "^(\s*)?(\+)?([- _():=+]?\d[- _():=+]?){10,14}(\s*)?$"></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="password" name="password" required pattern="[a-zA-Z1-9]{4}[a-zA-Z1-9]*"></td>
            </tr>
            <tr>
                <td><a href="login.jsp">login page</a></td>
                <td><input type="submit" value="sign up"></td>
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
