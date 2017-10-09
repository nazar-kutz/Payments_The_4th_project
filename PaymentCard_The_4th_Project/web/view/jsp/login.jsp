<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/jTextTags" prefix="jtext"%>
<html>
<head>
    <title><jtext:out value="title.login"/></title>
    <link rel="stylesheet" type="text/css" href="/view/css/login.css">
</head>
<body>
    <br><br><hr><br><br><br><br><br><br>
    <form action="/servlet/login" method="post">
        <table align="center">
            <tr>
                <td><jtext:out value="data.phone.number" after=": "/></td>
                <td><input type="text " name="login"></td>
            </tr>
            <tr>
                <td><jtext:out value="data.password" after=": "/></td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><a href="/view/jsp/registration.jsp"><jtext:out value="link.register.me"/></a></td>
                <td><input type="submit" value="<jtext:out value="button.sign.in"/>" style="background-image: url(../img/button_1.PNG); width: 50px"></td>
            </tr>
            <tr>
                <td colspan="2"><span style="color: red">
                    <jtext:err value="${error}"/>
                </span></td>
            </tr>
        </table>
    </form>
</body>
</html>
