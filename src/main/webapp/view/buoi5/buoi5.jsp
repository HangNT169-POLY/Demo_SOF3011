<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 22/01/2023
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login/check1" method="POST">
    <input type="text" placeholder="Username" name="username"/>
    <input type="password" placeholder="Password" name="password"/>
    <%--    <input type="submit" value="Submit">--%>
    <button>Submit</button>
</form>
${messs}
</body>
</html>
