<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 22/01/2023
  Time: 12:36
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

    MSSV: ${sinhVien.mssv}
    <br/>
    Ten:${sinhVien.ten}
    <br/>
    Tuoi:${sinhVien.tuoi}
    <br/>
    Dia chi: ${sinhVien.diaChi}
    <br/>
    Gioi tinh:
    <c:if test="${sinhVien.gioiTinh == 'true'}">Nam</c:if>
    <c:if test="${sinhVien.gioiTinh == 'false'}">Nữ</c:if>
    <%@include file="layout/footer.jsp" %>

</body>
</html>
