<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.09.2017
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/jTextTags" prefix="jtext"%>
<html>
<head>
    <title><jtext:out value="title.registration"/></title>
</head>
<body>
    <form action="/servlet/registration">
        <table>
            <tr>
                <td><jtext:out value="data.first.name" after=": "/></td>
                <td><input type="text" name="fname" required pattern="[a-zA-Z]+"></td>
            </tr>
            <tr>
                <td><jtext:out value="data.last.name" after=": "/></td>
                <td><input type="text" name="lname" required pattern="[a-zA-Z]+"></td>
            </tr>
            <tr>
                <td><jtext:out value="data.patronymic" after=": "/></td>
                <td><input type="text" name="patronymic" required pattern="[a-zA-Z]+"></td>
            </tr>
            <tr>
                <td><jtext:out value="data.phone.number" after=": "/> </td>
                <td><input type="text" name="phone" required pattern=
                        "^(\s*)?(\+)?([- _():=+]?\d[- _():=+]?){10,14}(\s*)?$"></td>
            </tr>
            <tr>
                <td><jtext:out value="data.password" after=": "/></td>
                <td><input type="password" name="password" required pattern="[a-zA-Z1-9]{4}[a-zA-Z1-9]*"></td>
            </tr>
            <tr>
                <td><a href="login.jsp"><jtext:out value="link.login.page"/></a></td>
                <td><input type="submit" value="<jtext:out value="button.sign.up"/>"></td>
            </tr>
            <tr>
                <td colspan="2"><span style="color: red">
                    <jtext:err value="${error}"/></span>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
