<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/21/2025
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    Nhap vao so: <input type="text" name="num"><br>
    <button type="submit">Hien thi</button>
</form>
<h4>
    <c:set var="n" value="${param.num}"/>
    <c:forEach var="i" begin="1" end="${n}">
        ${i}
    </c:forEach> <br>
    <c:forEach var="i" begin="1" end="${n}">
        <c:if test="${i % 2 == 0}">
            ${i}
        </c:if>
    </c:forEach> <br>
    <c:forEach var="i" begin="1" end="${n}">
        <c:if test="${i % 3 == 0}">
            ${i}
        </c:if>
    </c:forEach>
</h4>

</body>
</html>
