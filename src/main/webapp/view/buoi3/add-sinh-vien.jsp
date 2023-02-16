<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 22/01/2023
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="layout/header.jsp" %>

<form action="/sinh-vien/add" method="post">
    MSSV: <input type="text" name="mssv"/>
    <br/>
    Tên: <input type="text" name="ten"/>
    <br/>
    Tuổi: <input type="text" name="tuoi"/>
    <br/>
    Địa chỉ: <input type="text" name="diaChi"/>
    <br/>
    Giới tính:
    <input type="radio" name="gioiTinh" checked value="true"/>Nam
    <input type="radio" name="gioiTinh" value="false"/>Nữ
    <br/>
    <button>Add</button>
</form>
<%@include file="layout/footer.jsp" %>
</body>
</html>
