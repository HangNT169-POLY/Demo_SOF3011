<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 22/01/2023
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <form action="/sinh-vien/search" method="GET">
        Tên: <input name="ten"/>
        <button type="submit">Search</button>
    </form>
    <br/>
    <button><a href="/sinh-vien/view-add">Add Student</a></button>
    <tr>
        <th>ID</th>
        <th>Cate Name</th>
        <th>Cate Code</th>
        <th>Product Code</th>
        <th>Product Name</th>
        <th>Float</th>
        <th>Description</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="acc">
        <tr>
            <td>${acc.productId}</td>
            <td>${acc.categoryName}</td>
            <td>${acc.categoryCode}</td>
            <td>${acc.productCode}</td>
            <td>${acc.productName}</td>
            <td>${acc.price}</td>
            <td>${acc.description}</td>

            <td>
                <button><a href="/sinh-vien/detail?mssv=${acc.productId}"
                           class="btn btn-danger"> detail </a></button>
                <button><a href="/sinh-vien/delete?mssv=${acc.productId}"
                           class="btn btn-danger"> delete </a></button>
                <button><a href="/sinh-vien/view-update?mssv=${acc.productId}"
                           class="btn btn-danger"> update </a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
