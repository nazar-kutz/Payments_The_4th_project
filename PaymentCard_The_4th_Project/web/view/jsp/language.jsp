<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 09.10.2017
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/jTextTags" prefix="jtext" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title><jtext:out value="title.language"/></title>
    <link rel="stylesheet" type="text/css" href="/view/css/common.css">
    <link rel="stylesheet" type="text/css" href="/view/css/language.css">
</head>
<body>
<jsp:include page="/view/jsp/header.jsp"/>
<hr>
<h3 align="center"><jtext:out value="link.language"/></h3>
<hr>
<table class="language_table">
    <caption align="center"><jtext:out value="data.chose.language" after=": "/></caption>
    <tr>
        <form action="/servlet/language" method="post">
            <td><select name="language" size="1">
                <option value="en_US">English</option>
                <option value="uk_UA">Українська</option></select></td>
            <td><input type="submit" value="<jtext:out value="button.send"/>"></td>
        </form>
    </tr>
</table>
</body>
</html>