<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 22/01/2023
  Time: 12:58
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

<form action="/sinh-vien/update" method="post">
    MSSV: <input type="text" name="mssv" value="${sinhVien.mssv}"/>
    <br/>
    Tên: <input type="text" name="ten" value="${sinhVien.ten}"/>
    <br/>
    Tuổi: <input type="text" name="tuoi" value="${sinhVien.tuoi}"/>
    <br/>
    Địa chỉ: <input type="text" name="diaChi" value="${sinhVien.diaChi}"/>
    <br/>
    Giới tính:
    <c:choose>
        <c:when test="${sinhVien.gioiTinh == 'true'}">
            <input type="radio" name="gioiTinh" checked value="true"/>Nam
            <input type="radio" name="gioiTinh" value="false"/>Nữ
        </c:when>
        <c:otherwise>
            <input type="radio" name="gioiTinh" value="true"/>Nam
            <input type="radio" name="gioiTinh" checked value="false"/>Nữ
        </c:otherwise>
    </c:choose>
    <br/>
    <button>Update</button>
</form>
<%@include file="layout/footer.jsp" %>

</body>
</html>
