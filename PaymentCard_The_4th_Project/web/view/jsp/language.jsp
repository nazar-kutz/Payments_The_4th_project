<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 09.10.2017
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/jTextTags" prefix="jtext" %>
<html>
<head>
</head>
<body>
<form action="/servlet/language">
    <select name="language" size="1">
        <option value="en_US">English</option>
        <option value="uk_UA">Українська</option>
    </select>
    <input type="submit" value="<jtext:out value="button.send"/>">
</form>
</body>
</html>