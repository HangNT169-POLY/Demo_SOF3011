<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 22/01/2023
  Time: 11:31
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

<table>
    <form action="/sinh-vien/search" method="GET">
        Tên: <input name="ten"/>
        <button type="submit">Search</button>
    </form>
    <br/>
    <button><a href="/sinh-vien/view-add">Add Student</a></button>
    <tr>
        <th>MSSV</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sinhViens}" var="acc">
        <tr>
            <td>${acc.mssv}</td>
            <td>${acc.ten}</td>
            <td>${acc.tuoi}</td>
            <td>${acc.diaChi}</td>
            <td>
<%--                <c:choose>--%>
<%--                    &lt;%&ndash; When gioi tinh  == 'true' &ndash;%&gt;--%>
<%--                    <c:when test="${acc.gioiTinh=='true'}">--%>
<%--                        Nam--%>
<%--                    </c:when>--%>
<%--                    &lt;%&ndash; Otherwise &ndash;%&gt;--%>
<%--                    <c:otherwise>--%>
<%--                        Nữ--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>
                <c:if test="${acc.gioiTinh == 'true'}">Nam</c:if>
                <c:if test="${acc.gioiTinh == 'false'}">Nữ</c:if>
            </td>
            <td>
                <button><a href="/sinh-vien/detail?mssv=${acc.mssv}"
                           class="btn btn-danger"> detail </a></button>
                <button><a href="/sinh-vien/delete?mssv=${acc.mssv}"
                           class="btn btn-danger"> delete </a></button>
                <button><a href="/sinh-vien/view-update?mssv=${acc.mssv}"
                           class="btn btn-danger"> update </a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="layout/footer.jsp" %>

</body>
</html>
